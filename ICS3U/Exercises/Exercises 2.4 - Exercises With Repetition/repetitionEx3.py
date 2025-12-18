print("""Enter votes until all votes are accounted for. When this happens, enter nothing or 0. The choices are as follows.
1. Spencer
2. Linhan
3. Donald Duck""")
votes = {
    "Spencer": 0,
    "Linhan": 0,
    "Donald Duck":0
}
names = list(votes)
while True:
    inp = input()
    if not inp: break
    if int(inp) == 0: break
    if int(inp) > 3 or int(inp) < 1: continue
    inp = int(inp)
    votes[names[inp-1]] += 1
tally = list(votes.values())
highest_votes = max(votes, key=votes.get)
if (tally.count(votes[highest_votes]) > 1):
    print("There was a tie!")
else:
    print(f"{highest_votes} won the election!")

for i in range(3):
    try:
        percent = "%.2f" % (votes[names[i]]/sum(votes.values())*100)
    except ZeroDivisionError:
        percent = "0"
    print(f"{names[i]} earned {percent}% of the votes.")
