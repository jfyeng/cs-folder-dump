# James Feng
# listAssign2.py

from random import *

print("This tool will generate a random tournament bracket given some names!")
print("Please enter names one by one.")
print("To stop, simply press enter without entering a name.")

# Used to store names, will get used when fetching names.
names = []

while True:
    name = input(">> ").strip()
    if not name: # Exit when user presses enter without entering anything.
        break
    names.append(name)

# Add a name "Bye" if the amount of names is odd.
if len(names) % 2 == 1: 
    names.append("Bye")

longest = 0 # Used for spacing out names nicely.
pairs = [] # Used to store pairs.
while len(names):
    # Fetch two random names, and remove them from the list.
    p1 = names.pop(randrange(0, len(names)))
    p2 = names.pop(randrange(0, len(names)))
    
    # Match the pairs up in the pairs list.
    pairs.append([p1, p2])
    longest = max(longest, len(p1))

print(" -- MATCHES -- ")
for pair in pairs:
    print(f"{pair[0]:{longest}} VS. {pair[1]}")