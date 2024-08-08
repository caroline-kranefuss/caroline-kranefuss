from bank import value

def test_hello():
    assert value("hello") == 0
    assert value("HELLO") == 0

def test_hey():
    assert value("hey") == 20
    assert value("HEY") == 20

def test_else():
    assert value("bye") == 100
    assert value("BYE") == 100
