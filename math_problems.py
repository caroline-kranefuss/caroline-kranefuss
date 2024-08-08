def main():
    expression = str(input("Expression: "))
    math(expression)

def math(arithmetic):
    x, y, z = arithmetic.split(" ")
    x = float(x)
    z = float(z)
    if y == "+":
        print(x + z)
    elif y == "-":
        print(x - z)
    elif y == "/":
        print(x / z)
    elif y == "*":
        print(x * z)

main()
