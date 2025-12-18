# James Feng
# subtract.py
# A function that given two lists 'a' and 'b', will return a new list that contains all 
# items present in list 'a' not found in list 'b'.

def subtract(list_a: list, list_b: list) -> list:
        list_c = []
        # Run a basic loop checking whether each item in list a is in list b.
        for num in list_a:
                if not num in list_b:
                        list_c.append(num)
        return list_c

# Testing the function.
a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
b = [2, 3, 5, 8, 9]
print(subtract(a,b))