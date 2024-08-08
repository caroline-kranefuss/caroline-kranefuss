import sys
from csv import DictReader
from csv import DictWriter
import csv

if len(sys.argv) < 3:
    sys.exit("Too few command-line arguments")
if len(sys.argv) > 3:
    sys.exit("Too many command-line arguments")
else:
    try:
        with open(f'{sys.argv[1]}', 'r') as before_csv:
            dict_reader = DictReader(before_csv)
            before_csv = open(f'{sys.argv[1]}', 'r')
        with open(f'{sys.argv[2]}', 'w') as after_csv:
            dict_writer = DictWriter(after_csv, fieldnames=["first_name", "last_name", "home"])
            after_csv = open(f'{sys.argv[2]}', 'w')
            for line in before_csv:
                line = line.rstrip().split(",")
                student = {"first_name": None, "last_name": None, "house": None}
                students = []
                students.append(student)
                print(students, file=after_csv)
    except FileNotFoundError:
        sys.exit(f"Could not read {sys.argv[1]}")
