print("This program will help you identify if a triangle is equilateral, isoscles, or scalene.")
side1 = int(input("Enter length of a side >> "))
side2 = int(input("Enter length of another side >> "))
side3 = int(input("Enter length of final side >> "))

if side1 == side2 == side3:
    print("That is an equilaterial triangle!");
elif side1 != side2 != side3:
    print("That is a scalene triangle!");
else:
    print("That is an isosceles triangle!");