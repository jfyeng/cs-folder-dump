import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)

cur = 0
offset = 0
direction = 0.02
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        display.fill((0,0,0))

        offset += direction
        if (offset < -15 or offset > 15):
                direction = -direction

        p1 = [0, 0]
        p2 = [0, 0]
        for i in range(50, WS[1] - 50, 25):
                p1 = [0, i]
                for j in range(0, 50):
                        if (j % 2 == 0):
                                p2 = [j*25, i+offset]
                        else:
                                p1 = [j*25, i]
                        
                        pygame.draw.line(display, (0, 255, 0), p1, p2)

        pygame.display.flip()