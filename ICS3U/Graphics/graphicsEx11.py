import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

radius = 25
curPos = [0,0]
circles = []
holding = False
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        display.fill((255,200,200))

        for circle in circles:
                pygame.draw.circle(display, (111,111,111), circle, radius)
                pygame.draw.circle(display, (200,200,255), circle, radius-2) 
        if mb[0] and not holding:
                holding = True
                curPos = [mx,my]
                circles.append(curPos)
        if not mb[0] and holding:
                holding = False
        if holding:
                circles[len(circles)-1] = [mx,my]
        
        pygame.display.flip()
        clock.tick(60)