# James
# selection1.py
# GIVEN INSTRUCTIONS: 
# Write a program that converts a compass bearings (0 -360) to the nearest N, E, S, or W. 
# (If a bearing is half way between the points, pick N or S as appropriate.)
import sys

# I put all my code into functions for all 5 programs for speed, readability, and just because I like functions.
def main():
    print("This program will calculate which cardinal direction a given compass bearing in degrees would be facing.")
    # This list is used to store the names of the cardinal directions to easily print it later.
    directions = ["North", "East", "South", "West"]
    # If I don't get an integer value, I ask again.
    while True:
        try:
            degrees = int(input("Please enter degrees >> "))
        # Here I catch keyboardinterrupt error in case the user wants to terminate the program.
        except KeyboardInterrupt:
            print("\nKeyboardInterrupt received. Terminating program.")
            sys.exit()
        except:
            # I ask for a new value if I get a non-integer one.
            print("Please enter an integer value.")
            continue
        break

    # Applying operations on the degrees to make sure it is within 0-360.
    if degrees < 0:
        # If the degree is below 0, I invert it over to positive.
        degrees %= 360
        degrees = 360 - (360 - degrees)
    else:
        degrees %= 360

    # For each condition, if it is false, max won't choose it. Each has a unique coefficient 1-4 to identify it.
    dirRange = max(1*(315 <= degrees <= 360 or 0 <= degrees <= 45), 2*(46 <= degrees <= 134), 3*(135 <= degrees <= 225), 4*(226 <= degrees <= 314)) - 1
    # Based on the identification, I print out the right direction from my directions list.
    print(f"That is closest to {directions[dirRange]}!")
    
main()