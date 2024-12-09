""" 
Example of my usage of regular expressions
In a team of 6 runners, given each runners' unique preferences for legs in a relay race, assign each runner to a leg
such that the optimal arrangement is reached (ie each leg is run and by a runner who wants to run that leg.)
"""


import re

def get_runners():
    runners = {}
    counter = 0

    # Only 6 runners are allowed on a team. Depending on if the runner is already in the dictionary or not, increment or decrement the counter.
    while counter < 6:
        name = str(input("What's your name? ")).title()
        if name in runners:
            print("Runner already registered. Please enter a unique name, including last initial if needed.")
            counter -= 1
        preference = str(input("What slots would you like to run? "))
        runners[name] = preference
        counter += 1
    return runners

# Clean up the roster - split on commas
def clean_runners(roster):
    cleaned_roster = {}
    for key, value in roster.items():
        cleaned_value = sorted(re.sub("\D", "", value))
        cleaned_value_str = ''.join(cleaned_value)
        cleaned_roster[key] = cleaned_value_str
    return cleaned_roster

# Sort the runners 
def sort_runners(cleaned_runners):
    runners_in_order = {}
    counter = 1
    while counter < 7:
        for key, value in cleaned_runners.items():
            if len(value) == counter:
               runners_in_order[key] = value
        counter += 1
    return runners_in_order

# The most important function - one that assigns each runner to the slot that works
def assign_runners(assignments):
    slots = {}
    counter = 1
    while counter < 7:
        for key,value in assignments.items():
            if len(value) == 1:
                search_for = value
                slots[value] = key
            if search_for in value:
                new_value = value.replace(search_for, '')
                assignments[key] = new_value
        counter += 1
    for key, value in slots.items():
        print(f"{value} will run slot {key}.")

def main():
    assign_runners(sort_runners(clean_runners(get_runners())))

if __name__ == "__main__":
    main()
