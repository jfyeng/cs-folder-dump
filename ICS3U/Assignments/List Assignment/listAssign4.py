# James Feng
# listAssign4.py

print("This tool will tell you if a configuration for the game Assassin is valid.")
print("Enter your configuration, with space separated integers, with the i'th number being the target of person i.")

playerCount = 0 # Stores length of input.
# A try except block is used here because it makes it easy to handle index errors and other errors simultaneously.
try:
    config = list(map(int, input(">> ").split()))
    playerCount = len(config) # Keep track of player count.
    start = 0 # Starting at 0, because if the configuration is valid, we should be able to return here no matter what.
    depth = 1 # Keep track of how many players have been accounted for.
    curPlayer = config[start] # Keep track of which player we're at.
    visited = [] # Keep track of which players we've already visited.
    while True:
        visited.append(curPlayer)
        if config[curPlayer] in visited: # Stop if we've already visited the next node. This also catches if we've reached where we began.
            break
        curPlayer = config[curPlayer] # Jumping to this player's target.
        depth += 1
except: # If any error is encountered, assume the configuration is invalid.
    depth = 0

# We compare the depth to the player count. If we've visited all players, then the configuration is valid.
# If the depth does not match up with the player count, there's more than 1 loop. It would be invalid.
if depth == playerCount and playerCount > 0:
    print("That configuration is valid!")
else: 
    print("That configuration is invalid!")