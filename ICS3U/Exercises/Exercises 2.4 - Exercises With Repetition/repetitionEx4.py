width = 0.1
distance = 384472281600 # distance to moon in mm
counter = 0
while width < distance:
    width *= 2
    counter += 1

print(f"It would take {counter} folds of a paper to make a paper wide enough to reach the moon.")