def main():
    user_input = str(input("Input: "))
    remove_vowels(user_input)

def remove_vowels(sr_npt):
    list = [char for char in sr_npt]
    consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ0123456789?' "
    consonants_found = [char for char in list if char in consonants]
    prnt = ''.join(consonants_found)
    print(prnt, end = "\n")

main()
