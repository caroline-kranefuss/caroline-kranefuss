import sys

if len(sys.argv) < 2:
        sys.exit("Too few command-line arguments")
if len(sys.argv) > 2:
    sys.exit("Too many command-line arguments")
if not sys.argv[1].endswith(".py"):
    sys.exit("Not a Python file")

try:
    with open(sys.argv[1], "r") as file:
        lines = file.readlines()
        numlines=0
        for line in lines:
            if '#' in line or line=='\n':
                pass
            else:
                numlines += 1
        print(numlines)
except FileNotFoundError:
    sys.exit("File does not exist")
