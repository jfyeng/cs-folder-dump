import pygame
import sys

from random import *

WS = (800, 600)
display = pygame.display.set_mode(WS)

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if mb[0]:
                color = (randint(0,255),randint(0,255),randint(0,255))
                pygame.draw.line(display, color, (0,0), (mx,my))

                color = (randint(0,255),randint(0,255),randint(0,255))
                pygame.draw.line(display, color, (0,WS[1]), (mx,my))
                
                color = (randint(0,255),randint(0,255),randint(0,255))
                pygame.draw.line(display, color, (WS[0],0), (mx,my))

                color = (randint(0,255),randint(0,255),randint(0,255))
                pygame.draw.line(display, color, WS, (mx,my))

        pygame.display.flip()