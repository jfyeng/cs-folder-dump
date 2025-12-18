import pygame
import sys

display = pygame.display.set_mode((800, 600))

margin = 20
radius = 3
interval = 10
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if mb[0]:
                pygame.draw.circle(display, (0, 255, 0), (mx-margin, my-interval*2), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx-margin, my-interval), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx-margin, my), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx-margin, my+interval), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx-margin, my+interval*2), radius)

                pygame.draw.circle(display, (0, 255, 0), (mx-interval*2, my-margin), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx-interval, my-margin), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx, my-margin), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx+interval, my-margin), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx+interval*2, my-margin), radius)

                pygame.draw.circle(display, (0, 255, 0), (mx+margin, my-interval*2), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx+margin, my-interval), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx+margin, my), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx+margin, my+interval), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx+margin, my+interval*2), radius)

                pygame.draw.circle(display, (0, 255, 0), (mx-interval*2, my+margin), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx-interval, my+margin), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx, my+margin), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx+interval, my+margin), radius)
                pygame.draw.circle(display, (0, 255, 0), (mx+interval*2, my+margin), radius)
        
        pygame.display.flip()