# James Feng
# twoD3.py
# a function that when given a 2D list of integers, will find the greatest value,
# and return the indices of that integer in the 2D list.

def maxPos(twodee: list) -> tuple:
        # the currently known greatest value and its position in the 2D list
        highest = twodee[0][0]
        highest_pos = (0,0)

        for i, onedee in enumerate(twodee):
                for j, item in enumerate(onedee):
                        # if the current item is greater than the greatest, set the greatest to this item,
                        # then store the indices of this item
                        if item > highest:
                                highest = item
                                highest_pos = (i,j)

        return highest_pos

# testing the function
testlist = [
        [4,2,520,239],
        [40,405,329,230],
        [935,304,210,12]
]

print(maxPos(testlist))