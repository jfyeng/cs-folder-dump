import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
pygame.mouse.set_visible(False)

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        display.fill((0,0,0))
        pygame.draw.line(display, (0, 255, 0), (0, my), (WS[0], my))
        pygame.draw.line(display, (0, 255, 0), (mx, 0), (mx, WS[1]))
        
        pygame.display.flip()