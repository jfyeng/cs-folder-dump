import pygame
import sys

from random import *

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

corners = [(0,0), (0, WS[1]), (WS[0], 0), WS]

def distance(a, b):
        return ((a[0] - b[0])**2 + (a[1] - b[1])**2)**-1

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if mb[0]:
                closest = 0
                for i, corner in enumerate(corners):
                        if distance((mx,my), corner) > distance((mx,my), corners[closest]):
                                closest = i
                color = randint(0,255),randint(0,255),randint(0,255)
                pygame.draw.line(display, color, corners[closest], (mx,my))

        pygame.display.flip()
        clock.tick(60)