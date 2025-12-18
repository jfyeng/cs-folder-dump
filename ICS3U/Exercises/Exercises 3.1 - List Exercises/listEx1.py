# listEx1.py
import random
friends = ["spencer", "linhan", "alex", "the man in the mirror", "ricky"]
actions = ["hates", "loves", "killed", "found", "is suspicious of"]

for friend in friends:
    other = random.choice(friends)
    action = random.choice(actions)
    print(f"{friend} {action} {other}")