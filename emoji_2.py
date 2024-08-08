import emoji

def main():
    emoji_string = (input("Input: "))
    print(emoji.emojize(emoji_string, language="alias"))

if __name__ == "__main__":
    main()
