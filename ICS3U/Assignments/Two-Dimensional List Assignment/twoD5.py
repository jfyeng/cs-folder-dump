# James Feng
# twoD5.py
# a function that given a 2D list will check if there exists 4 consecutive 1's or 2's orthogonally (horizontal and vertical) or diagnally
# True is returned if so, False otherwise

# this contains 4 separate checks with relative coordinates that can be run at any 
# coordinate to check for the connect4 condition
relative = (
        ( # vertical
                (0,0),
                (1,0),
                (2,0),
                (3,0),
        ),
        ( # horizontal
                (0,0),
                (0,1),
                (0,2),
                (0,3),
        ),
        ( # diagnal top-left -> bottom-right
                (0,0),
                (1,1),
                (2,2),
                (3,3),
        ),
        ( # diagnal top-right -> bottom-left
                (0,0),
                (-1,1),
                (-2,2),
                (-3,3),
        )
)

def connect4(twodee: list) -> bool:
        for i in range(len(twodee)):
                for j in range(len(twodee[0])):
                        for player in range(1,3): # repeat for both players
                                for win_condition in relative:
                                        flag = False # when flag is true, there is no win found here

                                        # for every relative coordinate in the win condition, if any spot
                                        # is not the player's number, win condition breaks and we continue
                                        # otherwise, we found a winning player
                                        for rel in win_condition:
                                                # a bounds check
                                                if not (0 <= i + rel[0] < len(twodee)) or not (0 <= j + rel[1] < len(twodee[0])):
                                                        flag = True
                                                        break
                                                # check if the spot has the player's number
                                                if twodee[i + rel[0]][j + rel[1]] != player:
                                                        flag = True
                                                        break

                                        if not flag:
                                                return True
        return False

# testing the function

board1 = [[0,0,0,0,0,1],
          [0,0,0,0,1,1],
          [0,0,0,1,1,1],
          [0,0,0,0,0,2],
          [0,0,0,2,2,2],
          [0,0,0,0,0,2],
          [0,0,0,0,0,0]]

board2 = [[0,0,1,1,1,1],
          [0,0,0,2,2,2],
          [0,0,0,0,0,2],
          [0,0,0,0,0,0],
          [0,0,0,0,0,0],
          [0,0,0,0,0,0],
          [0,0,0,0,0,0]]

board3 = [[0,0,0,0,0,0],
          [0,0,0,0,0,0],
          [0,0,0,0,0,0],
          [0,0,2,1,2,1],
          [0,0,0,2,1,1],
          [0,0,0,0,2,1],
          [0,0,0,0,0,2]]

board4 = [[0,0,0,0,0,0],
          [0,0,0,0,0,2],
          [0,0,0,0,2,1],
          [0,0,0,0,2,1],
          [0,0,0,0,2,2],
          [0,0,0,0,2,1],
          [0,0,0,0,0,1]]

print(connect4(board1))  # False
print(connect4(board2))  # True
print(connect4(board3))  # True
print(connect4(board4))  # True
