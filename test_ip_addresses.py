from numb3rs import validate

def test_zeros():
    assert validate("0.0.0.0") == True

def test_letters():
    assert validate("hello") == False

def test_too_large():
    assert validate("255.255.255.256") == False
