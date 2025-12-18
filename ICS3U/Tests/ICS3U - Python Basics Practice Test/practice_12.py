prices = [
    [1, .1, .8],
    [101, .08, .6],
    [501, .05, .4]
]

def main():
    colorOrBlack = input("Would you like to print with colors (y/n)? >> ")

    if colorOrBlack == "y":
        color = 1
    else:
        color = 0

    while True:
        copyAmount = input("How many copies would you like to make? >> ")
        if copyAmount.isnumeric():
            copyAmount = int(copyAmount)
            break
        print("Please enter an integer.")
        continue

    # finding the right price range
    if copyAmount < 1:
        print("Zero copies have been printed at a cost of $0.00 per copy. Pleasure doing business!")
        return

    for i in range(len(prices)-1):
        if copyAmount >= prices[i][0]:
            priceRange = i

    if (copyAmount > 2000 and color == 0) or (copyAmount > 100 and color == 1):
        deliveryCost = 0
    else: 
        deliveryCost = 5
    
    totalPrice = "%.2f" % ((prices[priceRange][1+color] * copyAmount) + deliveryCost)
    print(f"With a delivery cost of ${deliveryCost}, your total is ${totalPrice}.")
    

print("Welcome to McKenzie's printing!")
main()