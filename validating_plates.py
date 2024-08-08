def main():
    plate = input("Plate: ")
    if is_valid(plate):
        if only_letters_and_numbers(plate):
            if two_letters_start(plate):
                if numbers_at_end(plate):
                    print("Valid")
                else:
                    print("Invalid")

def is_valid(s):
    if 1 < len(s) < 7:
        return True
    if len(s) == 1:
        print("Invalid")
    if len(s) > 6:
        print("Invalid")

def only_letters_and_numbers(t):
    if t.isalnum():
        return True
    else:
        print("Invalid")

def two_letters_start(u):
    if u[0].isalpha:
        if u[1].isalpha:
            return True
        else:
            print("Invalid")

def numbers_at_end(v):
    substring = v[:-1]
    if substring.isalpha:
        return True
    else:
        print("Invalid")

main()
