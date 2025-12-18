def letterMark(grade):
        if grade <= 50: return "F"
        if grade <= 54: return "D"
        if grade <= 59: return "D+"
        if grade <= 64: return "C"
        if grade <= 69: return "C+"
        if grade <= 74: return "B"
        if grade <= 79: return "B+"
        if grade <= 89: return "A"
        if grade <= 100: return "A+"

print(letterMark(76))