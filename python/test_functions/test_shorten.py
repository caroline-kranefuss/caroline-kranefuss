from twttr import shorten

def test_capitals():
    assert shorten("HELLO") == "HLL"

def test_lowercase():
    assert shorten("hello") == "hll"

def test_numbers():
    assert shorten("CS50") == "CS50"
