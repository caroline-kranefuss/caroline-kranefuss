def main():
    while True:
        try:
            _ = str(input("Fraction: "))
            numerator, denominator = map(int, _.split('/'))
            percent = round(numerator / denominator * 100)
        except (ValueError, ZeroDivisionError) as e:
            print("An error occurred:", e)
        else:
            break
    if percent > 100:
        main()
    elif percent <= 1:
        print("E")
    elif percent >= 99:
        print("F")
    else:
        print(f"{percent}%")

main()
