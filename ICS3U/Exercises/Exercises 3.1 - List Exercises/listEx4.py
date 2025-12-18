# listEx4.py
import random

snakes = [
    [14, 3],
    [39, 33],
    [20, 15],
    [88, 36],
    [66, 53],
    [69, 58],
    [84, 71],
    [79, 67],
]

ladders = [
    [6, 17],
    [24, 26],
    [30, 44],
    [49, 62],
    [82, 86],
]

finish = 90
turn = random.randint(0, 1)
players = [0, 0]
while True:
    roll = random.randint(1, 6) # MUA HA HA THEY NEVER HAD ANY CONTROL
    wait = input(f"--- Player {turn+1}: hit enter to roll >> ") 
    print(f"Player {turn+1} has rolled a {roll}!")
    if players[turn] + roll <= finish:
        players[turn] += roll
        for snake in snakes:
            if players[turn] == snake[0]:
                players[turn] = snake[1]
                print(f"SNAKE -- Player {turn+1} slid down a snake!")
        for ladder in ladders:
            if players[turn] == ladder[0]:
                players[turn] = ladder[1]
                print(f"LADDER -- Player {turn+1} climbed a ladder!")
    print(f"Player {turn+1} is now on square {players[turn]}!")
    if players[turn] == finish:
        print(f"Player {turn+1} has reached the end!\nPlayer {turn+1} wins!")
        break
    turn = (turn + 1) % 2
    