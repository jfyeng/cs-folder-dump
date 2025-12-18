import pygame
import sys

from pygame.locals import *

WINDOW_SIZE = (800, 600)
display = pygame.display.set_mode(WINDOW_SIZE)

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        for i in range(0, WINDOW_SIZE[0]*2, 10):
                pygame.draw.line(display, (0, 255, 0), (0, i), (i, 0))
                pygame.draw.line(display, (0, 255, 0), (i, 0), (WINDOW_SIZE[0], WINDOW_SIZE[0] - i))
                pygame.draw.line(display, (0, 255, 0), (0, i), (WINDOW_SIZE[1] - i, WINDOW_SIZE[1]))
        
        pygame.display.flip()