def main():
    grocery_list = {}
    while True:
        try:
            item = input("").upper()
            grocery_list[item] = grocery_list.get(item, 0) + 1
        except KeyError:
            pass
        except EOFError:
            break
    for item, grocery_list[item] in sorted(grocery_list.items()):
            print(f"{grocery_list[item]} {item}")

main()
