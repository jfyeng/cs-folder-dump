import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)
pygame.display.set_caption("written by james")
clock = pygame.time.Clock()

rect_size = 50
red = 125
increment = 0.1

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()

        display.fill((111, 111, 111))

        mrx, mry = int(mx / rect_size), int(my / rect_size)

        red += increment
        if red >= 255 or red <= 0: increment = -increment

        for x in range(0, WS[0], rect_size):
                for y in range(0, WS[1], rect_size):
                        if x / rect_size == mrx or y / rect_size == mry:
                                pygame.draw.rect(display, (red, 0, 0), (x, y, rect_size, rect_size))
                        pygame.draw.rect(display, (0, 0, 255), (x, y, rect_size, rect_size), 2)

        pygame.display.flip()