# James Feng
# twoD2.py
# a function called flatten that when given a 2D list, will 'flatten' the list.
# a single 1 dimensional list is returned.

def flatten(twodee: list) -> list:
        # using python's list concatenation to add all the lists together
        ans = []
        for onedee in twodee: ans += onedee
        return ans

# testing the function
testlist = [
        [5,6,7,8],
        [2,3,"bob",["john"]],
        [7,54,3,3]
]

print(flatten(testlist))