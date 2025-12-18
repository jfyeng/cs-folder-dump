import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

span = 50
height = 50

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if (mb[0]):
                for x in range(10):
                        pygame.draw.line(display, (0, 0, 255), (mx, my), (mx - span + x*10, my - height))
        
        pygame.display.flip()