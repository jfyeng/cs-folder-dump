# James Feng
# grid.py
# A function that given a position and size, uses python to draw a square at the position and 
# recursively draw 4 more squares internally until it gets too small, creating a grid.

import pygame
import sys

WS = (800, 800)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

def grid(pos: tuple, size: int) -> None:
        if size < 10: return # The base case triggers when size gets too small.

        # I tried with using draw.rect but it messed up the thickness and positions.
        # pygame.draw.rect(display, (0,0,255), (pos[0], pos[1], size, size), width=1)

        # Draw 4 lines that make up a square of sidelength 'size' with 'pos' being the topleft corner.
        pygame.draw.line(display, (0,0,255), pos, (pos[0]+size, pos[1]), width=1)
        pygame.draw.line(display, (0,0,255), pos, (pos[0], pos[1]+size), width=1)
        pygame.draw.line(display, (0,0,255), (pos[0]+size, pos[1]), (pos[0]+size, pos[1]+size), width=1)
        pygame.draw.line(display, (0,0,255), (pos[0], pos[1]+size), (pos[0]+size, pos[1]+size), width=1)

        # Recursively do this 4 times with halved sizes.
        grid(pos, size/2)
        grid((pos[0]+size/2, pos[1]), size/2)
        grid((pos[0], pos[1]+size/2), size/2)
        grid((pos[0]+size/2, pos[1]+size/2), size/2)

# Testing the function.
grid((25,25), 700)

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        pygame.display.flip()
        clock.tick(60)