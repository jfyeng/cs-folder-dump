import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

radius = 10

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if (mb[0]):
                pygame.draw.circle(display, (255, 0, 0), (WS[0] - mx, my), radius)
        
        pygame.display.flip()