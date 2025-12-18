print("Please enter all class grades. When you are completed, press enter without entering anything.")
passed, failed = 0, 0
grade = 1
while True:
    grade = input()
    if not grade:
        break
    else:
        grade = int(grade)
    if grade < 50: failed += 1
    if grade >= 50: passed += 1
print(f"You failed {failed} classes and passed {passed} classes.")