import pygame
import sys
import time

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

stripe_count = 40
stripes = [0] * stripe_count
width = WS[0] / stripe_count

display.fill((255,255,255))
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if (mb[0]):
                stripe_ind = int(mx / (WS[0] / stripe_count))
                stripes[stripe_ind] += 1

        for i in range(stripe_count):
                pygame.draw.rect(display, (255, 0, 0), (i * width, 0, width, width * stripes[i]))
        
        pygame.display.flip()
        clock.tick(60)