import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

BOX_SIZE = 50

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        display.fill((0,0,0))        

        bl = [mx-int(BOX_SIZE/2), my-int(BOX_SIZE/2)]
        bh = [bl[0]+BOX_SIZE, bl[1]+BOX_SIZE]

        for i in range(11):
                p1 = (0, i*60)
                p2 = (mx-30, my-30 + i*6)
                pygame.draw.line(display, (0, 255, 0), p1, p2)
                p1 = (WS[0], i*60)
                p2 = (mx+30, my-30 + i*6)
                pygame.draw.line(display, (0, 255, 0), p1, p2)
                p1 = (i*80, 0)
                p2 = (mx-30 + i*6, my-30)
                pygame.draw.line(display, (0, 255, 0), p1, p2)
                p1 = (i*80, WS[1])
                p2 = (mx-30 + i*6, my+30)
                pygame.draw.line(display, (0, 255, 0), p1, p2)
        
        pygame.display.flip()
        clock.tick(60)