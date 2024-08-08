from pyfiglet import Figlet
import random
import sys

figlet=Figlet()
all_fonts = figlet.getFonts()

if len(sys.argv) == 1:
    s = str(input("Input: "))
    random_font = random.choice(all_fonts)
    figlet.setFont(font=random_font)
    print(figlet.renderText(s))
elif len(sys.argv) == 2:
    print("Invalid usage")
    sys.exit(1)
elif len(sys.argv) == 3:
    font = sys.argv[2]
    if sys.argv[1] == '-f' or sys.argv[1] == '--font':
        if font in [str(x) for x in all_fonts]:
            s = str(input("Input: "))
            figlet.setFont(font=font)
            print(figlet.renderText(s))
        else:
            print("Invalid usage")
            sys.exit(1)
    else:
        print("Invalid usage")
        sys.exit(1)
else:
    sys.exit(1)
