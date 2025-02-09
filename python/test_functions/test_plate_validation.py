from plates import is_valid

def main():
    test_two_letters_start()
    test_length()
    test_numbers()
    test_only_letters_and_numbers()
    test_numbers_at_end()

def test_two_letters_start():
    assert is_valid("HE123") == True
    assert is_valid("H1234") == True
    assert is_valid("12345") == False

def test_length():
    assert is_valid("H") == False
    assert is_valid("HE") == True
    assert is_valid("HELLOW") == True
    assert is_valid("HELLOWO") == False

def test_numbers():
    assert is_valid("0CS") == False
    assert is_valid("5CS") == False
    assert is_valid("CS0") == False

def test_only_letters_and_numbers():
    assert is_valid("CS50") == True
    assert is_valid("CS50!") == False

def test_numbers_at_end():
    assert is_valid("CS50") == True
    assert is_valid("50CS") == False

if __name__ == "__main__":
    main()
