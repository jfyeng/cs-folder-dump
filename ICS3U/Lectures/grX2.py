import pygame
import sys
import os

os.chdir("Lectures")

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

ghost_img = pygame.image.load("ghost.png")
ghost_dim = ghost_img.get_width()/4, ghost_img.get_height()/4

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
                if event.type == pygame.MOUSEBUTTONDOWN:
                        ss = display.copy()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        if (mb[0]):
                display.blit(ss, (0, 0))
                pygame.draw.circle(display, (123, 88, 222), (mx, my), 15)

        #display.blit(pygame.transform.scale(ghost_img, ghost_dim), (WS[0]/2 - ghost_dim[0]/2, WS[1]/2 - ghost_dim[1]/2))
        
        pygame.display.flip()
        clock.tick(60)