def main():
    menu = {
    "Baja Taco": 4.25,
    "Burrito": 7.50,
    "Bowl": 8.50,
    "Nachos": 11.00,
    "Quesadilla": 8.50,
    "Super Burrito": 8.50,
    "Super Quesadilla": 9.50,
    "Taco": 3.00,
    "Tortilla Salad": 8.00
}

    total_price = 0

    while True:
        try:
            inputted_item = str(input("Item: "))
            item = inputted_item.title()
            if item not in menu:
                pass # or continue
            price = menu[item]
            total_price += price
            print_total(total_price)
        except EOFError:
            print_total(total_price)
            break
        except KeyError:
            pass

def print_total(total_price):
    print("Total: $" + "{:.2f}".format(total_price))



if __name__=='__main__':
    main()
