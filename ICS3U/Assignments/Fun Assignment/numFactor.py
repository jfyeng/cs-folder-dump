# James Feng
# numFactor.py
# A function that given an integer, returns the amount of integer factors it has.

def numFactor(n: int) -> int:
        # Making sure n is an integer.
        try: n = int(n)
        except: return -1

        if n == 0: return 0 # Zero would have an infinite amount of factors, but I don't want to return a string.

        # All numbers have at least 2 factors unless the number itself is 1.
        if n == 1: return 1
        factor_c = 2 # Factor count.
        # We only need to iterate up until the square root of N because anything above that would already have been considered.
        for i in range(2, int(n**(1/2))+1):
                if n % i == 0:
                        factor_c += 1
                        if n / i != i: 
                                factor_c += 1
        return factor_c

# Testing the function.
for i in range(0, 100):
    if numFactor(i) == 2:
        print(i, "is prime.")
