def main():
    greeting = str(input("Greeting: "))
    give(greeting)

def give(g):
    g_first_word = g.strip().title()
    g_first_letter = g[0]
    if g_first_word[:5] == "Hello":
        print("$0")
    elif g_first_letter == "H" or g_first_letter == "h":
        print("$20")
    else:
        print("$100")

main()
