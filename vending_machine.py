def main():
    print("Amount Due: 50")
    coin = int (input("Insert Coin: "))
    if coin not in (5, 10, 25):
        print("Amount Due: 50")
    else:
        print("Amount Due: ", end="")
        print(50 - coin)
    new_coin = int (input("Insert Coin: "))
    if new_coin not in (5, 10, 25):
        print("Amount Due: ", end="")
        print(50 - coin)
    else:
        print("Amount Due: ", end="")
        print(50 - coin - new_coin)
    while (coin + new_coin) < 50:
        print("Amount Due: ", 50 - (coin + new_coin))
        new_coin = int (input("Insert Coin: ")) + new_coin
    print("Change owed: ", (coin + new_coin) - 50)

main()
