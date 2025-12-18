# James
# selection2.py
# GIVEN INSTRUCTIONS: 
# Visit xe.comand find the Exchange rates from Canadian to five different currencies. 
# Create a Nice looking menu that lists the currency and rate.  Allow the user to choose 
# which currency he/she wants to buy and how much then tell them how much Canadian money 
# that will cost them.
import sys

# Used later for setting precision to 2 decimals.
f2 = "%.2f"

# Storing the conversion rates in a dictionary for easy access.
cadRates = {
    "CAD": 1,
    "USD": 0.7431359,
    "EURO": 0.68901809,
    "YEN": 110.99396,
    "YUAN": 5.3453332,
    "POUND": 0.58820045,
}

def main():
    print(f"Hello! This tool can help you convert CAD to:\n    {" - ".join(list(cadRates)[1:])}")

    # Similar to the last program, but now I look for a currency type that is in my dictionary.
    while True:
        try:
            # Used strip() here because leading or trailing spaces could cause it to be unrecognized even if it is valid.
            # Also used upper() as they are all uppercase in my dictionary.
            currency = input("What currency would you like to buy? >> ").strip().upper()
        except KeyboardInterrupt:
            print("\nKeyboardInterrupt received. Terminating program.")
            sys.exit()
        if not currency in list(cadRates):
            # Asking again if user inputted a money type we don't have.
            print(f"Sorry, that is not an option!")
            continue
        break

    # Asking for specifically an integer value.
    while True:
        try:
            amount = int(input(f"How much {currency} would you like to buy? >> "))
            if amount < 0:
                print("This tool isn't advanced enough to convert negative money!")
                continue
        except KeyboardInterrupt:
            print("\nKeyboardInterrupt received. Terminating program.")
            sys.exit()
        except:
            # Ask again if the user inputted a non integer value.
            print("Please enter an integer number.")
            continue
        break

    # Using basic math to calculate how much CAD the selected amount will cost, and formatting it to 2 decimal places.
    print(f"${f2%amount} in {currency} will cost you ${f2 % round(amount/cadRates[currency], 2)} CAD!")

main()