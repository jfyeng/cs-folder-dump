print("This program will draw a cool isosceles triangle for you!")
altitude = int(input("What size triangle do you want? (will be used as altitude) >> "))
if altitude >= 2:
    for i in range(0, altitude):
        print("*" * i)
    for i in range(0, altitude):
        print("*" * (altitude-i))

else:
    print("Invalid triangle size! Not enough pixels.")