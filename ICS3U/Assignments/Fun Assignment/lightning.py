# James Feng
# lightning.py
# A function that given a position, will call upon Zeus to strike from that position.
# (Make a lightning bolt that splits and moves downwards until it is off the screen or terminated.)

import pygame
import random
import sys

from math import *

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

def lightning(pos: tuple, lowbound: int = 10) -> None:
        if pos[1] > WS[1]: return # The position is off the screen.

        # Determine how far down the screen the next pos will be.
        # Also used to determine whether we should end the current branch.
        down = random.randint(lowbound, 50) 

        if down < 3: return # End branch if the down value is too low.
        for i in range(2 if random.randint(1,5) == 2 else 1): # Split into 1 or 2 bolts, favors splitting into 1 bolt.
                # Find new pos, draw a line to it, and recurse from that position.
                pos2 = (pos[0] + random.randint(-50,50), pos[1] + down)
                pygame.draw.line(display, (255,255,0), pos, pos2, width=2)
                lightning(pos2, max(0, lowbound-1))

# Testing the function.
last_drawn = 0
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()

        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()
        
        # Redraws a new lightning bolt after an interval using pygame's clock.
        if pygame.time.get_ticks() - last_drawn > 500:
                display.fill((0,0,0))
                lightning((WS[0]/2, 25))
                last_drawn = pygame.time.get_ticks()
        
        pygame.display.flip()
        clock.tick(60)