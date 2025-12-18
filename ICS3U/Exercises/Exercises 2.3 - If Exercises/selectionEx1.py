basePrice = float(input("enter base price >> "))

pst = 0.08 * basePrice
gst = 0
if basePrice >= 4:
    gst = 0.05 * basePrice

print(f"your total including ${pst} pst and ${gst} gst is: ${round(basePrice+pst+gst, 2)}.")