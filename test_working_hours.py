from working_hours import convert

assert ("9:05 AM to 10:00 AM") == ("09:05 to 10:00")

assert ("9 AM to 5 PM") == ("09:00 to 17:00")

assert ("5:00 PM to 9:00 AM") == ("17:00 to 09:00")

assert ("9 AM 5 PM") == ValueError

assert ("13 AM to 5 PM") == ValueError
