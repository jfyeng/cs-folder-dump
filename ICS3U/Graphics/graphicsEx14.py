import pygame
import sys
import random

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

radius = 19
colors = []
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        while (len(colors) < 20): colors.append((random.randint(0, 255), random.randint(0,255), random.randint(0, 255)))
        else:
                colors.insert(0, colors[19])
                colors.pop(20)

        for i in range(-1, 2):
                y = WS[1]/2 + i*radius*2
                for x in range(20):
                        pygame.draw.circle(display, colors[x], (27 + x * (radius*2) + 10, y), radius)
        
        pygame.display.flip()
        clock.tick(10)