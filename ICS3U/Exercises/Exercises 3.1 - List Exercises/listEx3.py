# listEx3.py
names = []
weeds = []
for i in range(10):
    names.append(input("Enter name of kid >> ").strip())
    weeds.append(int(input("-- How many weeds did this kid pull? >> ")))
totalWeedsPulled = 0
for weedCount in weeds: totalWeedsPulled += weedCount

for i in range(10):
    earned = round((weeds[i] / totalWeedsPulled) * 100, 2)
    print(f"{names[i]} earned ${'%.2f' % earned}")