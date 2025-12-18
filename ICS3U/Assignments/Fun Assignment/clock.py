# James Feng
# clock.py
# A function that given an amount of hours, an amount of minutes, and an amount of seconds,
# will use pygame to draw a clock that has hands corresponding to these values.

import pygame
import sys
import datetime

from math import *

WS = (800, 600)
display = pygame.display.set_mode(WS)

# Utility function that given a position, angle, and length, will calculate the point 
# at the end of a line of that length, starting from that position, and at that angle.
def xy(x, y, ang, length):
        return (x-cos(radians(ang))*length, y-sin(radians(ang))*length)

lengths = [40, 75, 80] # The lengths of the arms.
def clock(hours: int, minutes: int, seconds: int) -> None:
        global lengths

        hours %= 12 # Fix the hours if it is above 12.

        # The minutes and hours hands should slowly approach the next value as the seconds hands does its revolutions.
        # (If the time is 2:30, then the hour hand should be halfway between 2 and 3, not flat at 2 and teleport to 3 when it is 3:00).
        minutes += seconds/60
        hours += minutes/60

        # The 12 hour ticks.
        display.fill((255,255,255))
        for ang in range(0, 360, int(360/12)):
                pygame.draw.line(display, (0,0,0), xy(400, 300, ang, 80), xy(400, 300, ang, 90), width=3)

        pygame.draw.circle(display, (0,0,0), (400, 300), 100, width=2)

        # Drawing the three hands, minute and second hand extends both ways so I just add 180 degrees to their first point value.
        pygame.draw.line(display, (0,0,0), (400,300), xy(400, 300, 90+hours/12*360, lengths[0]), width=2)
        pygame.draw.line(display, (60,0,201), xy(400,300, 90+minutes/60*360+180, 20), xy(400, 300, 90+minutes/60*360, lengths[1]), width=2)
        pygame.draw.line(display, (75,210,118), xy(400,300, 90+seconds/60*360+180, 20), xy(400, 300, 90+seconds/60*360, lengths[2]), width=2)

# Testing the function.
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()

        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        time = datetime.datetime.now()
        clock(time.hour,time.minute,time.second)
        
        pygame.display.flip()