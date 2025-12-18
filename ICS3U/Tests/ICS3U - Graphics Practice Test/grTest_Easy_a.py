import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

size = 25

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        points = [(mx - size, my), (mx, my - size), (mx + size,my), (mx, my + size)]
        if (mb[0]): 
                pygame.draw.polygon(display, (0, 255, 0), points, width=1)
        
        pygame.display.flip()