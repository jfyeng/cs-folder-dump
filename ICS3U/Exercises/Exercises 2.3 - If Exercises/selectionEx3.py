print("hi! this program knows how much money you need to mail within canada, to the usa, or internationally.")
dest = input("where are you sending your mail? >> ").lower()
countryCosts = {
    "canada": 0.52,
    "usa": 0.93
}
internationalCost = 1.55

to = "within" if dest == "canada" else "to"
if dest in countryCosts:
    print(f"it will cost ${costs[dest]} to send your mail {to} {dest}.")
else:
    print(f"it will cost ${internationalCost} to send your mail internationally.")