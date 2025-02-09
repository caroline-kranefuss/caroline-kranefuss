def main():
    answer = str(input("What time is it? "))
    range(convert(answer))

def convert(time):
    if "a.m." in time:
        time = time[:-5]
        hours, minutes = time.split(":")
        hours = float(hours)
        minutes = float(minutes)
        time = hours + minutes/60
        return time
    elif "p.m." in time:
        time = time[:-5]
        hours, minutes = time.split(":")
        hours = float(hours) + 12
        minutes = float(minutes)
        time = hours + minutes/60
        return time
    else:
        hours, minutes = time.split(":")
        hours = float(hours)
        minutes = float(minutes)
        time = hours + minutes/60
        return time

def range(time):
    if 7.0 <= time <= 8.0:
        print("breakfast time")
    elif 12.0 <= time <= 13.0:
        print("lunch time")
    elif 18.0 <= time <= 19.0:
        print("dinner time")

if __name__ == "__main__":
    main()
