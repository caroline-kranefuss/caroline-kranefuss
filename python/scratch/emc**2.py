def main():
    # Get a mass from the user
    mass = int(input("m: "))
    # Convert mass to Energy
    convert(mass)
    # Print the result
    print("E: ", convert(mass))

def convert(m):
    return m * pow(300000000, 2)


main()
