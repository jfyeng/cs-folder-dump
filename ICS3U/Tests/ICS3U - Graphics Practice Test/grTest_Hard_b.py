import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

rgb = [0, 0, 0]
radius = 20
change = 0.2

display.fill((255,255,255))
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if (mb[0] or mb[1] or mb[2]):
                pygame.draw.circle(display, (rgb[0], rgb[1], rgb[2]), (mx, my), radius)
                if (mb[0]): rgb[0] = min(255, rgb[0] + change)
                if (mb[1]): rgb[1] = min(255, rgb[1] + change)
                if (mb[2]): rgb[2] = min(255, rgb[2] + change)

        rgb[0] = max(0, rgb[0] - change/3)
        rgb[1] = max(0, rgb[1] - change/3)
        rgb[2] = max(0, rgb[2] - change/3)

        pygame.draw.rect(display, (rgb[0], 0, 0), (0, 0, 50, 50))
        pygame.draw.rect(display, (0, rgb[1], 0), (55, 0, 50, 50))
        pygame.draw.rect(display, (0, 0, rgb[2]), (110, 0, 50, 50))
        pygame.draw.rect(display, (rgb[0], rgb[1], rgb[2]), (165, 0, 50, 50))
        
        pygame.display.flip()