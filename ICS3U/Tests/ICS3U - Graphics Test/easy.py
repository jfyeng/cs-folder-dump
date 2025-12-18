
import pygame
import sys
import random

WS = (800, 600)
display = pygame.display.set_mode(WS)
pygame.display.set_caption("written by james")
clock = pygame.time.Clock()

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if mb[0]:
                x = random.randint(0, WS[0])
                pygame.draw.circle(display, (random.randint(0,255),random.randint(0,255),random.randint(0,255)), (x, my), 5)
        if mb[2]:
                display.fill((0,0,0))

        pygame.display.flip()