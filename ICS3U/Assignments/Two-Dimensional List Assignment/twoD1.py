# James Feng
# twoD1.py
# a function called empty, that when given a 2D list, will check if the list contains only zeros
# True is returned if so, False is returned otherwise

def empty(twodee: list) -> bool:
        # looping through every single list, and every item in those lists to see if it's not zero
        for onedee in twodee:
                for item in onedee:
                        if item != 0:
                                return False
        return True

# testing the function
testlist = [
        [0,0,0,0],
        [0,0,0,0],
        [0,0,0,0]
]

print(empty(testlist))