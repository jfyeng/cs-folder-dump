guestCount = int(input("enter how many people eating pizza >> "))

ee = 32 % guestCount
print(f"option1: {int((32-ee)/guestCount)} slices each, {ee} left over")
print(f"option2: {32/guestCount} slices each")