def main():
    termCount = input("Enter the number of terms (depth) >> ")

    if not termCount.isnumeric() or int(termCount) < 0:
        print("Invalid input.")
        main()
    
    termCount = int(termCount)

    currentTerm = 0
    for i in range(1, termCount+1):
        currentTerm += (1/i)
    
    print(f"The series (1/1 + 1/2 + 1/3 + 1/4 + ...) arrives at approximately {"%.3f"%currentTerm} with {termCount} terms.")

print("This is a tool for calculating terms in the series that goes like so: 1/1 + 1/2 + 1/3 + 1/4 + ...")
main()