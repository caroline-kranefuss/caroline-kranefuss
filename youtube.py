import re

def main():
    print(parse(input("HTML: ")))

def parse(s):
    matches = re.search(r"(http[s]?://[www\.]?youtube.com/embed/)([\w]+)\"", s, flags=re.IGNORECASE)
    if matches:
        url = matches.group(1)
        url = ''.join(url)
        url = url.replace("youtube", "youtu.be")
        url = url.replace(".com", "")
        if "http:" in url:
            url = url.replace("http", "https")
        url = url.replace("embed/", "")
        after_bit = matches.group(2)
        after_bit = ''.join(after_bit)
        return f"{url}{after_bit}"

if __name__ == "__main__":
    main()
