# James
# selection5.py
# GIVEN INSTRUCTIONS: 
# Write a trivia program. This program will ask the user 10 questions. 
# After each question get the user answer and indicate whether it was right or wrong. 
# After all 10 questions, the computer will indicate the % correct. Your questions 
# must be trivia, not trivial (e.g. Star Wars trivia is good, what colour is the sky, 2 + 2 = ? are both bad.)
# Your quiz must also have a theme (e.g., movies, sports, your favorite video game. Your program should
# not care in what case the user answers the questions in. 
# e.g.."vincent massey" should be good enough when the answer is "Vincent Massey".
import sys

# Here I stored all the questions and answers.
# On the left side is the question, on the right side are all possible answers stored in a list.
# Note that the most preferred answer is at index 0 of each list, so that when I print out the answer, that one will be chosen.
trivia = {
    "What is the name of one of the most popular anime today, involving sorcerors and cursed spirits?": ["Jujutsu Kaisen", "Jujutsu", "Kaisen", "JJK"],
    "What popular anime character's body has the properties of rubber?": ["Monkey D. Luffy", "Luffy", "Monkey D Luffy", "Monkey"],
    "What is the name of one of the most memed anime that involves floating spirits that like punching stuff and stopping time?": ["Jojo's Bizarre adventure", "Jojo", "JJBA", "Jojo Bizarre Adventure", "Jojos", "Jojo's"],
    "What popular anime involves demons in japan, and sword techniques to exterminate the demons?": ["Kimetsu No Yaiba", "KNY", "Demon Slayer", "DS", "Kimetsu"],
    "What color are the dragon balls from Dragon Ball Z?": ["orange", "yellow", "yellowish orange","orangish yellow", "orange yellow","yellow orange"],
    "What weapon type is the main weapon of Akame from \"Akame Ga Kill!\"?": ["katana", "sword", "a katana", "a sword"],
    "Who is the deadly assassin from Spy X Family?": ["Yor Forger","Yor","Yor Briar","Thorn Princess"],
    "Who is the character with the fastest attack speed in Sword Art Online?": ["Yuuki Asuna", "Yuuki", "Asuna Yuuki", "Asuna"],
    "What species is Ryuk from Death Note?": ["a Shinigami", "Shinigami"],
    "What is the biggest problem of Saitama from One Punch Man? (try to give a basic answer.)": ["being too strong","hes too strong","hes too powerful","power","too strong","too powerful","Saitama is too powerful","Saitama is too strong","hes too OP","he is too OP","Saitama is too OP","too OP","being too OP","being too powerful","no worthy opponents","too much power", "he is too strong"],
}

def main():
    print("This program is trivia!")
    print("The theme is \"Anime\"!")
    print(f"""There are {len(trivia)} questions in total.
The answer is not case sensitive, and there's some leeway in how you answer.
Please still input an answer that would reasonably be interpreted as the correct one.\n""")
    
    # Track how many questions the user gets correct.
    correct = 0
    # The wrong variables will be stored in a list because I intend to let the user know what the answers were in the end.
    wrong = []
    # Convert dict to list for easy access to the questions and not the answers.
    questions = list(trivia)
    for i in range(len(trivia)):
        # Printing out the question and awaiting answer.
        # Input is edited to get an easy-to-compare string.
        guess = input(f"{i+1}. " + list(trivia)[i] + " >> ").strip().replace(" ", "").replace("'", "").lower()
        # Check if it was right or wrong, and prints out whether it was right or wrong.
        # The answers are formatted. Very hard to read, and probably not optimal, but it does work.
        # The reason why I didn't just make the answers stored in the dict formatted by default is because I want to print out the right ones later.
        if guess in map(lambda f: f.lower(), map(lambda t: t.replace("'", ""), map(lambda s: s.replace(" ", ""), trivia[questions[i]]))):
            print("That was correct!")
            correct += 1
        else:
            print("That was incorrect!")
            # If wrong, we add the index of the question that was incorrect so that later we can refer to it for the correct answer.
            wrong.append(i)
            
    # This is just for proper english. Add an "s" unless the count is 1.
    s = "s" if correct != 1 else "" 
    print(f"You got {correct} question{s} out of {correct+len(wrong)} questions correct. ({"%0.1f" % round(correct/(correct+len(wrong))*100,1)})%")
    # For every wrong answer, print out that they got it wrong, and what the right answer was.
    for wron in wrong:
        print(f"You got question {wron+1} wrong. The answer was \"{trivia[questions[wron]][0]}\".")

main()