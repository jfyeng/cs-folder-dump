import pygame
import sys

WS = (800, 600)
display = pygame.display.set_mode(WS)

x, y = WS[0]/2, WS[1]/2
start, end = [x, y], [x, y]
done = False

d = 0
step = 5
directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

while True:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        pygame.quit()
                        sys.exit()
        mx, my = pygame.mouse.get_pos()
        mb = pygame.mouse.get_pressed()
         
        if not done:
                for val in start + end:
                        if (0 <= val <= max(WS[0], WS[1])):
                                pass
                        else:
                                done = True
                                break
                if not done:
                        end = [start[0] + directions[d][0]*step, start[1] + directions[d][1]*step]
                        d = (d+1) % 4
                        step += 5
                        pygame.draw.line(display, (0, 255, 0), start, end)
                        start = end

        pygame.display.flip()