import inflect
p = inflect.engine()

# Get names
names = []
while True:
    try:
        name = str(input("Name: "))
        if not name:
            break
        names.append(name)
    except EOFError:
        break


#Join with inflect and print
names = p.join((names))
print("Adieu, adieu, to " + names)
