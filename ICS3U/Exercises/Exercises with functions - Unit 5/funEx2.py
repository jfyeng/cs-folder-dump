def palindrome(word):
        word_copy = word
        word = ""
        for c in word_copy:        
                if c in "qwertyuiopasdfghjklzxcvbnm":
                        word += c
        if word[::-1] == word:
                return True
        return False

given_word = input()
print(palindrome(given_word))