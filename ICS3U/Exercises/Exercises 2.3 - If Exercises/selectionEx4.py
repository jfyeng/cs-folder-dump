pythonLength = float(input("how long is your python? (in feet) >> ").replace(" ", "").replace("'", "").replace("feet", ""))
ans = 6*0.5 + (((pythonLength-6)*0.75)*int(pythonLength>6))
print(f"you need a minimum area of {round(ans, 2)} square feet for a python {round(pythonLength, 2)} feet long.")