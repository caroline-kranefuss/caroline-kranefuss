# Specify as command-line arg the number of Bitcoins, n, they'd like to buy
        # "Missing command-line argument"
    # If cannot convert to float, sys.exit with error message
        # "Command-line argument is not a number"
# Query the API for the price index site
    # Catch exceptions
# Output USD (4 dec places, sep , and .)
# Try except for requests

import sys
import requests

value = sys.argv[1]

value = float(value)

def get_rate_float(dct, i):
    return list(dct.values())[i]

if type(value) == float:
    if len(sys.argv) < 2:
        sys.exit("Missing command-line argument")
    elif len(sys.argv) > 2:
        sys.exit("Too many command-line arguments")
    else:
        try:
            response = requests.get("https://api.coindesk.com/v1/bpi/currentprice.json")
            info = response.json()
            for key in info["bpi"]["USD"]:
                 # Ex: bpi":{"USD":{"code":"USD","symbol":"&#36;","rate":"69,714.082","description":"United States Dollar","rate_float":69714.0821},"GBP":{"code":"GBP","symbol":"&pound;","rate":"54,832.566","description":"British Pound Sterling","rate_float":54832.5655},"EUR":{"code":"EUR","symbol":"&euro;","rate":"64,422.435","description":"Euro","rate_float":64422.4347}}}
                 rate = get_rate_float(info["bpi"]["USD"], 4)
                 rate = float(rate)
            USD_value = float(rate * value)
            USD_value_thousands = f"{USD_value:,}"
            print("$",USD_value_thousands, sep="", end="")
        except requests.RequestException:
            pass
else:
    sys.exit("Command-line argument is not a number")
