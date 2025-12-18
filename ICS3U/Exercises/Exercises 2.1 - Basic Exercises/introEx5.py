p1 = list(map(int, input("enter point 1 'x, y': ").split(", ")))
p2 = list(map(int, input("enter point 2 'x, y': ").split(", ")))
print(((p2[1] - p1[1])**2 + (p2[0] - p1[0])**2) ** 0.5)