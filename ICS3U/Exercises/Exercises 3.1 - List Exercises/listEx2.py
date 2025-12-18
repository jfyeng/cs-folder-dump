# listEx2.py
fruits = ["apple", "orange", "watermelon", "grapefruit", "grapes", "banana", "dragonfruit", "coconut", "cherries", "pineapple"]
prices = [1, 1, 6, 3, 4, 1, 2, 2, 4, 5]
form = "%.2f"

print("- Welcome to the unnamed fruit stand! -")
print("___---___---___---___---___---___---___")
for i in range(len(fruits)):
    fruit = fruits[i][0].upper() + fruits[i][1:]
    print(f"| > {fruit} for ${form % prices[i]}")
print("---___---___---___---___---___---___---")