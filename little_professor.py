import random

def main():
    generate_integer(get_level())

def get_level():
    while True:
        try:
            level = int(input("Level: "))
            if level in [1,2,3]:
                return level
            else:
                pass
        except ValueError:
            pass

def generate_integer(level):
    x, y = [], []
    for _ in range(10):
        x.append(random.randint(1 * 10**(level-1), 10**(level) - 1))
    for _ in range(10):
        y.append(random.randint(1 * 10**(level-1), 10**(level) - 1))
    score = 0
    for i in range(10):
        answer = x[i] + y[i]
        print(x[i], "+", y[i], "= ", end="")
        guess = int(input(""))
        if answer == guess:
            pass
            score +=1
        else:
            for j in range(2):
                print("EEE")
                print(x[i], "+", y[i], "= ", end="")
                guess = int(input(""))
            print(answer)
    print(score)

if __name__ == "__main__":
    main()
