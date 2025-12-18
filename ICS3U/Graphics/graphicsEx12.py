import pygame
import sys
import math

# USAGE CONSTANTS
INTERVAL = 50
OFFSET = 20
LINE_LENGTH = 30
RADIUS = 4

WS = (800, 600)

display = pygame.display.set_mode(WS)

last = 0
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        # rendering
        display.fill((255,255,255))
        
        for x in range(25, WS[0], INTERVAL):
                for y in range(25, WS[1], INTERVAL):
                        angle = math.atan2(y - my, x - mx) + math.pi # difference in y, difference in x
                        pygame.draw.circle(display, (0, 0, 0), (x, y), RADIUS)
                        pygame.draw.line(display, (0,0,0), (x,y), (x + math.cos(angle) * LINE_LENGTH,y + math.sin(angle) * LINE_LENGTH), 3)

        pygame.display.flip()