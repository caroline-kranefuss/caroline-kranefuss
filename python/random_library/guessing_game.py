""" 
Using the random library to create a game to guess what number the computer is thinking of
"""

import random

def get_level(): #doesn't take an argument here or above
    while True:
        try:
            number = int(input("Level: "))
            if number > 0:
                return number
            else:
                pass
        except ValueError:
            pass

def generate_number(number_generated):
    return random.randint(1, number_generated)

def guess(number_generated):
    while True:
        try:
            guess = int(input("Guess: "))
            if guess > 0:
                if guess > number_generated:
                    print("Too large!")
                    pass
                elif guess < number_generated:
                    print("Too small!")
                    pass
                else:
                    print("Just right!")
                    break
            else:
                pass
        except ValueError:
            pass

def main():
    guess(generate_number(get_level())) #so cool; can split up if big


if __name__ == "__main__":
    main()
