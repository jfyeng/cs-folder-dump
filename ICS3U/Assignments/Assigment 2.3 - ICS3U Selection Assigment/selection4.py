# James
# selection4.py
# GIVEN INSTRUCTIONS: 
# Write  a  program  that  processes  a  credit  card  application.
# Based  on  the  input  values,points are obtained. Based on the total points, various actions are taken.
# Points
# Age: 
# <= 20 -10
# 21-30 0
# 31-50 20
# >50 25
# At current address: 
# < 1yr -5
# 1-3yr 5
# 4-8yr 12
# > 8 20
# Annual income: 
# <=$20000 0
# <= $45000 12
# <=$70000 24
# > $70000 30
# At same job: 
# < 2yr -4
# 2-4yr 8
# > 4yr 15
# Actions: 
# <=20 points no card
# 21-35 card with $500 limit
# 36-60 card with $5000 limit
# >60 card with $10000 limit
import sys

# Storing all possible outcomes for easy access later.
results = [
    "no card",
    "a card with a $500 limit",
    "a card with a $5,000 limit",
    "a card with a $10,000 limit"
]

def main():
    print("This tool will help you process your credit card application.")
    print("Any information you give will not be saved.")

    # This will keep track of our points.
    points = 0
    # Here we look for floats only.
    while True:
        try:
            # These are all floats to allow for accuracy for the years portion.
            age = float(input("How old are you? (in years) >> ").strip())
            income = float(input("What is your annual income? (in dollars) >> ").strip())
            address = float(input("How long have you been living at your current address (in years)? >> ").strip())
            job = float(input("How long have you been working at your current job (in years)? >> ").strip())
            break
        except KeyboardInterrupt:
            print("\nKeyboardInterrupt received. Terminating program.")
            sys.exit()
        except:
            # Ask again if we get a non float value.
            print("Please only enter floats and integer values.")

    # Just a really long block of if statements used to tally the points.
    if age <= 20: points += -10
    if 31 <= age <= 50: points += 20
    if age > 50: points += 25
    
    if 20001 <= income <= 45000: points += 12
    if 45001 <= income <= 70000: points += 24
    if 70000 < income: points += 30

    if address < 1: points += -5
    if 1 <= address <= 3: points += 5
    if 4 <= address <= 8: points += 12
    if 8 < address: points += 20

    if job < 2: points += -4
    if 2 <= job <= 4: points += 8
    if 4 < job: points += 15

    if points <= 20: result = results[0]
    if 21 <= points <= 35: result = results[1]
    if 36 <= points <= 60: result = results[2]
    if 60 < points: result = results[3]

    # Finally, we deliver the result.
    print(f"You will receive {result}.")

main()