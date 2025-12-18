import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

span = 25

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        display.fill((111, 255, 111))
        for x in range(-50, WS[0] + 50, 20):
                for y in range(-50, WS[1] + 50, 20):
                        radius = ((mx - x)**2 + (my - y)**2)**(1/2) * 0.03
                        pygame.draw.circle(display, (111, 111, 111), (x, y), radius)
        
        pygame.display.flip()