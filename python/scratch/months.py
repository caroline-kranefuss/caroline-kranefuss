def main():
    months = [
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    ]
    d = str(input("Date: "))
    if '/' in d:
        if not any(char.isalpha() for char in d):
            dl = d.split(sep='/')
            dl.insert(0, dl.pop(-1))
            if int(dl[1]) > 12:
                main()
            if int(dl[2]) > 31:
                main()
            if len(dl[1]) == 1:
                dl[1] = '0' + dl[1]
            if len(dl[2]) ==1:
                dl[2] = '0' + dl[2]
            dls = '-'.join(dl)
            print(dls)
        else:
            main()
    else:
        if ',' in d:
            d_no_commas = d.replace(',', '')
            dl = d_no_commas.split()
            dl.insert(0, dl.pop(-1))
            if int(dl[2]) > 31:
                main()
            if len(dl[2]) ==1:
                dl[2] = '0' + dl[2]
            for element in months:
                if element == dl[1]:
                    dl[1] = str(months.index(element) + 1)
            if len(dl[1]) ==1:
                dl[1] = '0' + dl[1]
            dls = '-'.join(dl)
            print(dls)
        else:
            main()


main()

# and 0 <= month < len(dl) and month < len(months)
