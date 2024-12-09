def main():
    camelCase = str(input("camelCase: "))
    camelCase = camelCase.strip()
    camel_to_snake(camelCase)

def camel_to_snake(camelCase):
    for i in camelCase:
        n = 0
        for i in camelCase:
            if i.isupper() is True:
                camelCase = camelCase[:n] + "_" + camelCase[n:]
                n = n + 1
            n = n + 1
        break
    snake_case = camelCase
    print(snake_case.lower())

main()
