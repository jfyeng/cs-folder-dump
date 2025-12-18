import pygame
import sys
import time

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

bounds = [5, 40]
circles = []
radius = bounds[0]
dir = 1
last_tick = 0

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        now = pygame.time.get_ticks()
        if now - last_tick > 15:
                radius += dir
                if (radius < bounds[0] or radius > bounds[1]): dir = -dir
                last_tick = now

        display.fill((255, 255, 255))
        if (mb[0]):
                circles.append((mx, my))
        
        for circle in circles:
                pygame.draw.circle(display, (0, 0, 255), (circle[0], circle[1]), radius, width=1)
        
        pygame.display.flip()
        clock.tick(60)