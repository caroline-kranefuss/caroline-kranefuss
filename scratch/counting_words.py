import re

def main():
    print(count(input("Text: ")))

def count(s):
  pattern =r"\b([U-u]m)\b"
  matches = re.findall(pattern, s)
  print(len(matches))

if __name__ == "__main__":
    main()

#[^a-zA-Z]*(um|UM|uM|Um)+[^a-zA-Z]*
