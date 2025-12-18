def knightMove(row, col):
        lshape = [(1, 2), (1, -2), (2, 1), (2, -1), (-1, 2), (-1, -2), (-2, 1), (-2, -1)]
        possible = []
        for move in lshape:
                if row+move[0] >= 1 and row+move[0] <= 8 and col+move[1] >= 1 and col+move[1] <= 8:
                        possible.append((row+move[0], col+move[1]))
        return possible

from pygame import *

def drawBox(screen,col,x,y):
    ''' Draws one coloured box on the screen at grid position x,y.
        Board starts at location 200,100. Each box is 50 pixels apart.
    '''
    sx = x*50 + 150
    sy = y*50 + 50
    draw.rect(screen,col,(sx,sy,48,48))
    draw.rect(screen,(255,255,255),(sx,sy,48,48),1)

def showBoard(screen,kx,ky,moves):
    ''' Draws the whole board to the screen. The colour is based on logical contents.
        Position of knight - Blue
        Position knight can move - Yellow
        All others - Pink
    '''
    for x in range(1,9):
        for y in range(1,9):
            drawBox(screen,(255,111,111),x,y)
    for x,y in moves:
        drawBox(screen,(255,255,111),x,y)
        
    drawBox(screen,(111,111,255),kx,ky)


screen = display.set_mode((800,600))

moves = []
running =True
while running:
    for e in event.get():
        if e.type == QUIT:
            running = False

    mx,my = mouse.get_pos()
    boardx = (mx-150)//50
    boardy = (my-50)//50
    if 1<=boardx<=8 and 1<=boardy<=8:
        moves = knightMove(boardx,boardy)
        showBoard(screen,boardx,boardy,moves)
    display.flip()


quit()