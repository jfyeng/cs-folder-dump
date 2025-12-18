import pygame
import sys
import math
from random import *

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

def distance(a, b):
        return ((a[0] - b[0])**2 + (a[1] - b[1])**2)**(1/2)

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if mb[0]:
                color = (randint(0,255),randint(0,255),randint(0,255))
                dist = distance((mx,my), (WS[0]/2, WS[1]/2))
                radius = round(dist/7.5)
                pygame.draw.circle(display, color, (mx,my), radius)
        
        pygame.display.flip()
        clock.tick(60)