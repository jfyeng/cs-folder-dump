# James
# repetition3.py

print("""----HEART ATTACKS ON A BUN -----
1.  The Big MOO Combo . . . 5.99
2.  Big MOO . . . . . . . . 3.99
3.  Spring Surprise . . . . 1.99
4.  Fries . . . . . . . . . 1.29
5.  Pop . . . . . . . . . . 1.19
6.  Exit  
--------------------------------""")

items = {
    "1": 5.99,
    "2": 3.99,
    "3": 1.99,
    "4": 1.29,
    "5": 1.19
}

chosen = []

while True:
    prompt = input("What would you like? >> ")
    if not prompt:
        continue
    try: prompt = int(prompt)
    except:
        print("Please enter an integer.")
        continue
    if prompt == 6:
        break
    if prompt < 1 or prompt > 6:
        print("That is not an option!")
        continue
    
    if not prompt in chosen:
        chosen.append(str(prompt))
        if len(chosen) == len(list(items)):
            break

if not "4" in chosen:
    fries = input("Would you like any fries with that? (y/n) >> ")
    if fries == "y": chosen.append("4")

total = 0
for item in chosen:
    total += items[item]

print(f"Your total is ${"%.2f" % total}.")