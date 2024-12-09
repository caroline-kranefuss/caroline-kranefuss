"""
A program using the datetime library to compare a date of birth and "sing" the number of minutes from then to today's date
"""

from datetime import datetime
from datetime import timedelta
import inflect
import sys
import re

class Date:
    def __init__(self, date_occurence):
        self.date_occurence = date_occurence

    def __str__(self):
        return f"{self.date_occurence}"

    def __sub__(self, other):
        time_diff = self.date_occurence - other.date_occurence
        return time_diff

def main():
    sing(compare(get_dob()))

def get_dob():
    date_of_birth = str(input("Date of Birth: "))
    format = "%Y-%m-%d"
    try:
        date_of_birth = datetime.strptime(date_of_birth, format)
        return Date(date_of_birth)
    except ValueError:
        sys.exit("Invalid date")

def compare(dob):
    todays_date = Date(datetime.today())
    difference = todays_date - dob
    return difference

def sing(date_difference):
    days_only = date_difference.days
    minutes = days_only * 24 * 60
    inflector = inflect.engine()
    words = inflector.number_to_words(minutes)
    sing = re.sub(' and', ',', words).capitalize()
    print(f"{sing} minutes")

if __name__ == "__main__":
    main()
