def main():
    # Get an input
    phrase = input()
    # Convert text to emoticons
    convert(phrase)

def convert(phrase):
    # Convert text to emoticons
    happyPhrase = phrase.replace(":)", "🙂")
    sadPhrase = happyPhrase.replace(":(", "🙁")
    # Rename sadPhrase for clarity
    emoticonPhrase = sadPhrase
    # Print the new input
    print(emoticonPhrase)

main()
