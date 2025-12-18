for i in range(1, 100):
    persist = 0
    n = i
    while True:
        if len(str(n)) < 2: break
        prod = 1
        for char in str(n):
            prod *= int(char)
        n = prod
        persist += 1
    if persist > 3:
        print(f"The two digit number {i} has a persistence of {persist}.")