strin = input("enter a string >> ")
fieldSize = int(input("enter a field size >> "))
xes = int((fieldSize - len(strin))/2)
print(xes*"." + strin + xes*".")