#.#.#.# --> each # is btween 0 and 255 inclusive

import re

def main():
    print(validate(input("IPv4 Address: ")))


def validate(ip):
    pattern = r"^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5]\.){4}$"
    match = re.match(pattern, ip)
    if match:
        return True
    else:
        return False

if __name__ == "__main__":
    main()
