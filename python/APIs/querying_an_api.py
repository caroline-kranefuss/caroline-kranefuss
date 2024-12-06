"""
Example of my ability to query an API. 
The problem is to query to price index site for bitcoin and convert a given command-line argument from bitcoin to USD.
"""

import sys
import requests

def query_api():
    
    # Specify as command-line arg the number of Bitcoins, n, they'd like to buy
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
                # Query the API for the price index site
                response = requests.get("https://api.coindesk.com/v1/bpi/currentprice.json")
                info = response.json()
                for key in info["bpi"]["USD"]:
                     # Ex: bpi":{"USD":{"code":"USD","symbol":"&#36;","rate":"69,714.082","description":"United States Dollar","rate_float":69714.0821},"GBP":{"code":"GBP","symbol":"&pound;","rate":"54,832.566","description":"British Pound Sterling","rate_float":54832.5655},"EUR":{"code":"EUR","symbol":"&euro;","rate":"64,422.435","description":"Euro","rate_float":64422.4347}}}
                     rate = get_rate_float(info["bpi"]["USD"], 4)
                     rate = float(rate)
                USD_value = float(rate * value)
                USD_value_thousands = f"{USD_value:,}"
                # Output USD (4 dec places, sep , and .)
                print("$",USD_value_thousands, sep="", end="")
            # If cannot convert to float, sys.exit with error message
            except requests.RequestException:
                pass
    else:
        sys.exit("Command-line argument is not a number")

def main():
    query_api()

if __name__ == "__main__":
    main()
