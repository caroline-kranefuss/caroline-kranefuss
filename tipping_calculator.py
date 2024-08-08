def main():
    dollars = dollars_to_float(input("How much was the meal? "))
    percent = percent_to_float(input("What percentage would you like to tip? "))
    tip = dollars * percent
    print(f"Leave ${tip:.2f}")

def dollars_to_float(d):
    # Accept $##.## as an input
    # Remove $
    dStripped = d.strip("$")
    # Return amount as a float
    floatD = float(dStripped)
    # return float(d)
    return floatD


def percent_to_float(p):
    # Accept ##% as an input
    # Remove %
    pStripped = p.strip("%")
    # Return percentage as a float
    floatP = float(pStripped) * 0.01
    # return float(p)
    return floatP

main()
