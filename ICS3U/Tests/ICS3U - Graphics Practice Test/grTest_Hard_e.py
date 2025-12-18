import pygame
import sys
import time

WS = (800, 600)
display = pygame.display.set_mode(WS)
clock = pygame.time.Clock()

square_count = 40
size = int(WS[0] / square_count)

colors = [(255,255,255)] * square_count

y = WS[1]/2 - size/2
last_tick = 0
while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()
        
        display.fill((255, 255, 255))

        if (mb[0]): m_color = (255, 0, 0)
        elif (mb[2]): m_color = (0, 255, 0)
        else: m_color = (255, 255, 255)


        for i in range(square_count):
                pygame.draw.rect(display, colors[i], (i*size, y, size, size))
                pygame.draw.rect(display, (0, 0, 0), (i*size, y, size, size), width=1)

        pygame.draw.circle(display, m_color, (mx, my), 10)
        if (abs(my - WS[1]/2) <= size/2):
                ind = int(mx / size)
                colors[ind] = m_color

        now = pygame.time.get_ticks()
        if (now - last_tick > 30):
                colors.insert(0, colors[len(colors)-1])
                colors.pop(len(colors)-1)
                last_tick = now

        pygame.display.flip()