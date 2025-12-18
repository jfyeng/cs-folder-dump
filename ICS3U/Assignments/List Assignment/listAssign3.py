# James Feng
# listAssign3.py

# This is the code I used while setting this up to easily get the data from the website https://www.infoplease.com/countries/canada/canadian-prime-ministers-since-1867
#terms = []
#prompt = input()
#while prompt:
#    term = list(prompt.split())
#    termTime = term[0]
#    lastName = term[len(term)-2]
#    terms.append([termTime, lastName])
#    prompt = input()
#print(",\n".join(map(str, terms)))

from random import *

# Used for nice spacing when wrong answer feedback is printed out.
WIDTH = 42
# Stores all answers and dates. Term number can be calculated by adding 1 to the index here.
terms = [
    ['1867–1873', 'Macdonald'], 
    ['1873–1878', 'Mackenzie'], 
    ['1878–1891', 'Macdonald'],
    ['1891–1892', 'Abbott'],
    ['1892–1894', 'Thompson'],
    ['1894–1896', 'Bowell'],
    ['1896', 'Tupper'],
    ['1896–1911', 'Laurier'],
    ['1911–1917', 'Borden'],
    ['1917–1920', 'Borden'],
    ['1920–1921', 'Meighen'],
    ['1921–1926', 'King'],
    ['1926', 'Meighen'],
    ['1926–1930', 'King'],
    ['1930–1935', 'Bennett'],
    ['1935–1948', 'King'],
    ['1948–1957', 'Laurent'],
    ['1957–1963', 'Diefenbaker'],
    ['1963–1968', 'Pearson'],
    ['1968–1979', 'Trudeau'],
    ['1979–1980', 'Clark'],
    ['1980–1984', 'Trudeau'],
    ['1984', 'Turner'],
    ['1984–1993', 'Mulroney'],
    ['1993', 'Campbell'],
    ['1993–2003', 'Chretien'],
    ['2003–2006', 'Martin'],
    ['2006–2015', 'Harper'],
    ['2015-', 'Trudeau']
]

print("""This program will quiz you on which person was prime minister during a given time!
You will be given the term number, and the date of the term. You should input the last name of the prime minister.""")

notChosen = list(range(0,len(terms))) # Store all usable indexes.
AC = 0 # Store amount of correct answers.
WA = [] # Store indexes of wrong answers.
questionCount = min(10, len(terms)) # Stores total amount of questions to be asked. Adjustable.
term = randint(0, len(terms)-1) # Randomly chosen every time a question is asked.

for i in range(questionCount):
    term = choice(notChosen) # Pick an index at random.
    notChosen.remove(term) # Remove it from the list to avoid choosing the same one again.

    print(f"{i+1}. Who was prime minister at Term {term+1}, during {terms[term][0]}?")
    userAnswer = input(">> ").strip() # Get input and remove leading and trailing spaces.
    if userAnswer.upper() == terms[term][1].upper(): # Compare user answer with correct one.
        print("That was correct!".center(WIDTH))
        AC += 1
    else:
        print("That was incorrect!".center(WIDTH))
        WA.append([term, userAnswer]) # Add a list containing index and user answer for display later.
        
print("<< You have completed the quiz. >>".center(WIDTH))

print(f"You scored {(AC/questionCount*100):.0f}%!".center(WIDTH))
# I usually hate making big if statements like this, but it's easier to do here.
if AC == questionCount:
    print("You are an expert on the prime ministers of Canada!".center(WIDTH))
elif AC >= questionCount * .9:
    print("You know all about the prime ministers of Canada!".center(WIDTH))
elif AC >= questionCount * .7:
    print("You know the prime ministers of Canada really well!".center(WIDTH))
elif AC >= questionCount * .6:
    print("You know the prime ministers of Canada fairly well!".center(WIDTH))
elif AC >= questionCount * 0:
    print("You may need to study some more!".center(WIDTH))
    
# Print out wrong answers in a nice table, as a quality of life feature.
if len(WA):
    print("-- Wrong Answers --".center(WIDTH))
    print("Term  Date       Answer        Your Answer")
    print("------------------------------------------")
    for answer in WA:
        userAnswer = answer[1] if answer[1] else "N/A" # Get user answer, or N/A if they entered nothing.
        # Okay this line is a little long but I think it's definitely readable.
        print(f"{answer[0]+1:4}  {terms[answer[0]][0]:9}  {terms[answer[0]][1]:12}  {userAnswer}")