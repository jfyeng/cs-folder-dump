# James
# selection3.py
# GIVEN INSTRUCTIONS: 
# Transit Windsor Bus fares are as follows:
# Category: [1 Ticket] [10 Tickets] [Tranzip Pass]
# Adult:      $2.35       $20.30         $75
# Senior:     $1.60       $15.60         $38.50
# Student:    $1.60       $15.60         $52
# Write a program that gets the user's age category and whether 
# they want one ticket, ten tickets or a one month pass and tells them the cost.
import sys

# Same 2 decimal digit thing as last time.
f2 = "%.2f"
# Storing all the prices in a 2D list for easy access.
prices = [[2.35, 20.30, 75], [1.60, 15.60, 38.50], [1.60, 15.60, 52]]
# Storing age groups so that we can check whether the user entered a valid one.
ages = ["adult", "senior", "student"]

def main():
    print("This program will help you buy a train ticket or pass!")
    # Looking for an age group that is available.
    while True:
        try:
            age = input(f"Please enter your age group ({", ".join(ages)}) >> ").strip().lower()
        except KeyboardInterrupt:
            print("\nKeyboardInterrupt received. Terminating program.")
            sys.exit()
        if not age in ages:
            # Ask again if the user inputted one that is not an option.
            print("That is not an option!")
            continue
        break
    # Finding the index of the selected age group.
    age = ages.index(age)
    # Outputting a nice little menu for user convenience.
    print(f"The prices for {ages[age]}s are:\n${f2%round(prices[age][0], 2)} for one ticket.\n${f2%round(prices[age][1], 2)} for ten tickets.\n${f2%round(prices[age][2],2)} for a one month pass.")
    # Asking user to select a valid choice.
    while True:
        try:
            choice = input(f"What would you like? (one ticket, ten tickets, one month pass) >> ").strip().lower()
        except KeyboardInterrupt:
            print("\nKeyboardInterrupt receieved. Terminating program.")
            sys.exit()

        # Figuring out which one they entered, and setting the right cost.
        if choice in ["one ticket", "one", "one tickets", "1", "1 ticket", "1 tickets"]:
            # We set the cost to the appropriate price, and change the choice to something easy to print out.
            cost = prices[age][0]
            choice = "one ticket"
        elif choice in ["ten tickets", "ten", "ten ticket", "10 tickets", "10 ticket", "10"]:
            cost = prices[age][1]
            choice = "ten tickets"
        elif choice in ["one month pass", "month pass", "pass", "a pass", "1 month pass"]:
            cost = prices[age][2]
            choice = "one month pass"
            choice = "a " + choice
        else:
            print("Please choose a valid option.")
            continue 
        break

    # Finally, once again using the formatter for 2 decimal digits, rounding our total, and outputting.
    print(f"Your choice of {choice} will cost you ${f2 % round(cost, 2)}.")

main()