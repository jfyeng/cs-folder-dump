import pygame
import sys

display = pygame.display.set_mode((800, 600))

length = 20
radius = 20
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if (mb[0]):
                pygame.draw.line(display, (255, 0, 0), (mx-length, my-length), (mx+length,my+length))
                pygame.draw.line(display, (255, 0, 0), (mx-length, my+length), (mx+length, my-length))
        if (mb[2]):
                pygame.draw.circle(display, (0, 255, 0), (mx, my), radius, width=1)
        
        
        pygame.display.flip()