import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

def drawface(pos, size, surf):
        pygame.draw.circle(surf, (0,0,0), (pos[0] - size/2, pos[1]-size/3), size/4)
        pygame.draw.circle(surf, (0,0,0), (pos[0] + size/2, pos[1]-size/3), size/4)
        pygame.draw.rect(surf, (0,0,0), (pos[0] - size/2, pos[1] + size/2, size, size/3))
        pygame.draw.rect(surf, (0,0,0), (pos[0] - size/2-size/4, pos[1]+size/4, size/3, size/3))
        pygame.draw.rect(surf, (0,0,0), (pos[0] + size/2, pos[1]+size/4, size/3, size/3))

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        display.fill((255,255,255))

        drawface((200,300), 50, display)
        drawface((600,300), 200, display)
        
        pygame.display.flip()
        clock.tick(60)