x = 1
incr = 1
for i in range(64):
    incr *= 2
    x += incr
print(f"The king had to pay {x/7000:0.2f} pounds.")