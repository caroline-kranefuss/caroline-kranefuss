import sys
import tabulate
from csv import DictReader

if len(sys.argv) < 2:
    sys.exit("Too few command-line arguments")
if len(sys.argv) > 2:
    sys.exit("Too many command-line arguments")
if ".csv" not in sys.argv[1]:
    sys.exit("Not a CSV file")
else:
    try:
        with open(sys.argv[1], 'r') as sicilian:
            dict_reader = DictReader(sicilian)
            s = list(dict_reader)
            vals = []
            for each_dict in s:
                vals.append(list(each_dict.values()))
                    # or can write in one line as vals = [list(each_dict.values()) for each_dict in s]
            s_table = tabulate.tabulate(vals,headers=list(s[0].keys()),tablefmt='grid')
            print(s_table)
    except FileNotFoundError:
        sys.exit("File does not exist")
