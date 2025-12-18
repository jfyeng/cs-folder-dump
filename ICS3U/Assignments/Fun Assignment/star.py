# James Feng
# star.py
# A function that given a position, size, and color, uses pygame to draw a star of that size
# at that position, using that color.

import pygame
import sys

from math import *

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

def star(pos: tuple, size: int, color: tuple) -> None:
        points = [] # Contains the points used by pygame to draw the star.

        # A star has 10 vertices, and every other angle is a 'concave' angle and the others are 'convex' angles.
        # Knowing this, we can iterate through the 10 angles, alternating between long and short distances from the center,
        # and find all the points we need to draw the star.
        for ang in range(0,360,36):
                if (ang / 36) % 2 == 0:
                        ang = radians(ang+90)
                        points.append((pos[0] + cos(ang)*size, pos[1] - sin(ang)*size))
                else:
                        ang = radians(ang+90)
                        points.append((pos[0] + cos(ang)*size/3, pos[1] - sin(ang)*size/3))

        pygame.draw.polygon(display, color, points)

# Testing the function.
star((400,300), 50, (255,255,255))
star((600,200), 20, (255,255,0))

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()

        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()
        
        pygame.display.flip()
        clock.tick(60)