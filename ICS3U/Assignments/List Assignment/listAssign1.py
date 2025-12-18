# James Feng
# listAssign1.py

words = [] # Used to store words.
scores = [] # Used to store the scores of words.

print("This is a scrabble tool to tell you which words are below average!")
print("Please enter words one by one, with the word and its score separated by a space. Example: >> banana 10")
print("To end, simply press enter without entering anything.")

while True:
    # A try and except block is used here to know when to exit.
    try:
        word, score = input(">> ").strip().split(" ")
    except:
        break
    score = int(score)
    words.append(word)
    scores.append(score)

# Calculate total score.
total = 0
for score in scores: 
    total += score

# This if statement avoids dividing by zero if no input is given.
if len(words) > 0:
    # Getting the average, by dividing total score across word count.
    avg = total / len(words)
    print(f"The average was {round(avg, 3):.2f}")

    # Sorted version of list.
    sorte = scores.copy()
    sorte.sort()

    # Use the sorted list to see if any words are below average at all.
    if avg <= sorte[0]:
        print("There were no words below average.")
    else:
        print("The words below average were:")
        # Enumerate is used to keep track of the index, so it can be used to fetch the string of the word, stored in the words list.
        for i, score in enumerate(scores):
            if score < avg:
                print(f"\"{words[i]}\" with a score of {scores[i]}")
else:
    print("There were no words below average.")