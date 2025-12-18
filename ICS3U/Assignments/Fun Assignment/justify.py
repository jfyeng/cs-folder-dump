# James Feng
# justify.py
# A function that given a list of strings and an integer field size, will return a string as big as the field size,
# and with the string in the list spaced out from each other evenly.

def justify(words: list, field_size: int) -> str:
        # In the case that the list of empty, the output should be the field size filled with spaces.
        if len(words) == 0: return " " * field_size

        # We need to know how many characters the words take up so we know how many spaces we can work with.
        total_char = 0
        for word in words: total_char += len(word)

        # In the case that there is only 1 word, the output should be the 1 word on the left 
        # with the rest of the string being spaces.
        if len(words) == 1: 
                return words[0] + " " * (field_size - total_char)

        # In the case that the field size is too small to contain all the words with spaces between them,
        # the output should be all the words separated by one space.
        if field_size <= total_char + len(words)-1:
                return " ".join(words)
        else:
                gaps = ["" for _ in range(len(words)-1)] # List of strings used to store the sizes of the gaps.
                added_spaces = 0 # Counter to keep track of how many spaces have been added
                i = 0
                while added_spaces < field_size - total_char: # Iterate until we use up all the available spaces.
                        gaps[i] += " "
                        added_spaces += 1
                        i = (i + 1) % len(gaps) # Iterating through the gaps list and looping, to keep the gaps even.
                
                # Constructing the final string using the words and gaps.
                final = ""
                for i in range(len(gaps)):
                        final += words[i] + gaps[i]
                final += words[-1]

                return final

# Testing the function.
print(justify(["Hello", ",", "world", "!"], 2))
print(justify(["This", "is", "a", "function", "assignment!"], 35))
print(justify(["This"], 35), "end")

story = [
"Vincent Massey Secondary School has again",
"received top marks from the Fraser Institute.",
"The national think-tank, which provides annual",
"test scores for schools across Ontario,",
"released its findings this month.",
"",
"Most schools in Windsor-Essex showed improvement,",
"but Massey scored highest locally with 8.2 out of",
"10 to finish 50th out of 740 schools in the province.",
"",
"St. Anne Catholic High School in Lakeshore was the",
"second place local finisher for the 2015-2016 year",
"with a score of 8.1 and earning 57th place.",
""
"Schools are scored based on seven academic indicators",
"found in the results of annual math and literacy",
"tests.",
"",
"When the institute released its report on elementary",
"schools in December, Bellewood Public School scored",
"top marks for the area with a 9.3 — good enough for",
"35th place out of 2,900 schools across the province."]

for line in story:
    print("|",justify(line.split(),56),"|")