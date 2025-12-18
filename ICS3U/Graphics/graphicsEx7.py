import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        for x in range(0, 800, 10):
                y = .004 * (x-400) ** 2 + 100
                for cy in range(int(y), 600, 10):
                        pygame.draw.circle(display, (0, 255, 0), (x, cy), 4)
        
        pygame.display.flip()
        clock.tick(60)