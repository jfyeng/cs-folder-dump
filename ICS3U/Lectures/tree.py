import pygame
import random
import sys

from math import *

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

def tree(x, y, angle, size):
        angle = angle % 360
        x2, y2 = x + cos(radians(angle)) * size, y - sin(radians(angle)) * size
        pygame.draw.line(display, (0,255,0), (x,y), (x2,y2))
        if size > 5:
                tree(x2, y2, angle-random.randint(25,35), size-10)
                tree(x2, y2, angle, size-10)
                tree(x2, y2, angle+random.randint(25,35), size-10)

last_drawn = 0

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()

        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()
        
        if pygame.time.get_ticks() - last_drawn > 50:
                display.fill((0,0,0))
                tree(400, 550, 90, 90)
                last_drawn = pygame.time.get_ticks()
        
        pygame.display.flip()
        clock.tick(60)