import re

def main():
    print(convert(input("Hours: ")))

def convert(s):

    # Expected Inputs:
    # 9:00 AM to 5:00 PM
    # 9 AM to 5 PM
    # 9:00 AM to 5 PM
    # 9 AM to 5:00 PM

    # Convert to:
    # 9:00 to 17:00

    pattern = r"^([0-9]|[1][0-2])(?:\:[0-5][0-9])? ([AP]M) to ([0-9]|[1][0-2])(?:\:[0-5][0-9])? ([AP]M)"
    match = re.search(pattern, s, flags=re.IGNORECASE)
    if match:
        if "PM" in match.groups(2)[1] or "pm" in match.groups(2)[1] or "pM" in match.groups(2)[1] or "Pm" in match.groups(2)[1]:
            time_1 = int(''.join(map(str, match.groups(1)[0]))) + 12
        else:
            time_1 = int(''.join(map(str, match.groups(1)[0])))
            pattern_zero = r"((?P<number>[1-9])([\:|\s]))"
            match_zero = re.search(pattern_zero, s)
            if match_zero:
                number_zero = match_zero.group("number")
                time_1 = int(''.join(map(str, number_zero.groups(1)[0])))
                time_1 = '0' + str(time_1)
            else:
                time_1 = int(''.join(map(str, match.groups(1)[0])))
        if "PM" in match.groups(4)[3] or "pm" in match.groups(4)[3] or "pM" in match.groups(4)[3] or "Pm" in match.groups(4)[3]:
            time_2 = int(''.join(map(str, match.groups(3)[2]))) + 12
        else:
            time_2 = int(''.join(map(str, match.groups(3)[2])))
            pattern_zero = r"((?P<number>[1-9])([\:|\s]))"
            match_zero = re.search(pattern_zero, s)
            if match_zero:
                number_zero = match_zero.group("number")
                time_2 = int(''.join(map(str, number_zero.groups(1)[0])))
                time_2 = '0' + str(time_2)
            else:
                time_2 = int(''.join(map(str, match.groups(1)[0])))
        time_tuple = (time_1, ':00 to ', time_2, ':00')
        time_string = f"{time_tuple[0]}{time_tuple[1]}{time_tuple[2]}{time_tuple[3]}"
        return time_string
    else:
        ValueError

if __name__ == "__main__":
    main()
