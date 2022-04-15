#include <cs50.h>
#include <stdio.h>
#include <string.h>
// #include <iostream.h>

long getUserInput();
bool checkDigitLength(long userInput);
bool checksum(long userInput);
bool checkType(long userInput);
bool mathToCheckAmex(long userInput);
bool mathToCheckMC(long userInput);
bool mathToCheckVisa(long userInput);

int main(void){
    //get user input
    long userInput = getUserInput();

    // check digit length
    bool isValid = checkDigitLength(userInput);

    //check if it's a valid cc #
    if(isValid){
        isValid = checksum(userInput);
    }

    //check starting number
    if(isValid){
        checkType(userInput);
    }

    else{
        printf("INVALID\n");
    }
}

long getUserInput(){
    long userInput = get_long("Number: ");
    return userInput;
}

bool checkDigitLength(long userInput){
    int fifteenPlusDigits = userInput / (10^(14));
    int thirteenPlusDigits = userInput / (10^(12));
    return (fifteenPlusDigits > 0 && fifteenPlusDigits < 100) || (thirteenPlusDigits >= 1 && thirteenPlusDigits <= 9);
}

bool checksum(long userInput){
    // these are counters for the sums we need
    int productsDigitsSum = 0;
    int otherDigitsSum = 0;

    // this calculates the sums we need by iterating through each digit
    for (int i = 1; (10^i) <= userInput; i += 2){
        // 10th, 1000th, etc place digit of the cc
        int digit = userInput % (10^(i+1)) / 10^i;
        int doubledDigit = digit * 2;
        // doubledDigit will always be between 0 and 18, so no for loop needed
        int tens = doubledDigit /10;
        int ones = doubledDigit % 10;
        // 1th, 100th, etc place digit of the cc
        int otherDigit = userInput % (10^i) / 10^(i-1);

        // these are the counters in action
        productsDigitsSum += (tens + ones);
        otherDigitsSum += otherDigit;
    }

    // checking if our total sum's last digit is zero
    int totalSum = productsDigitsSum + otherDigitsSum;
    if(totalSum % 10 != 0){
        return false;
    } else{
        return true;
    }
}

bool checkType(long userInput){
    if (mathToCheckAmex(userInput)){
        printf("AMEX\n");
        return true;
    }
    else if (mathToCheckMC(userInput)){ //do I need is true here?
        printf("MASTERCARD\n");
        return true;
    }
    else if (mathToCheckVisa(userInput))
    {
        printf("VISA\n");
        return true;
    }
    else{
        return false;
    }
}

bool mathToCheckAmex(long userInput){
    // cleans up 15 digit cc number so only first two digits remain; name that a new variable
    int AmexfirstTwoDigits = userInput - (userInput % 10^(13));
    // what is the remainder of this new variable when divided by (34 * (10^13)) or (35 * (10^13))?
    int remainderZeroThirtyFour = AmexfirstTwoDigits % (34 * (10^(13)));
    int remainderZeroThirtyFive = AmexfirstTwoDigits % (35 * (10^(13)));
    if((remainderZeroThirtyFive != 0) || (remainderZeroThirtyFive != 0)){
        return false;
        }
    else{
        return true;
        }
}

bool mathToCheckMC(long userInput){
    // cleans up 16 digit cc number so only first two digits remain; name that a new variable
    int MCfirstTwoDigits = userInput - (userInput % 10^(14));
    // what is the remainder of this new variable when divided by (51 * (10^14)) or (52 * (10^14)) or ... or (55 * (10^14))?
    int remainderZeroFiftyOne = MCfirstTwoDigits % (51 * (10^(14)));
    int remainderZeroFiftyTwo = MCfirstTwoDigits % (52 * (10^(14)));
    int remainderZeroFiftyThree = MCfirstTwoDigits % (53 * (10^(14)));
    int remainderZeroFiftyFour = MCfirstTwoDigits % (54 * (10^(14)));
    int remainderZeroFiftyFive = MCfirstTwoDigits % (55 * (10^(14)));
    if((remainderZeroFiftyOne != 0) || (remainderZeroFiftyTwo != 0) ||
        (remainderZeroFiftyThree != 0) || (remainderZeroFiftyFour != 0) ||
        (remainderZeroFiftyFive != 0)){
        return false;
        }
    else{
        return true;
        }
}

bool mathToCheckVisa(long userInput);
    //cleans up 13 or 16 digit cc number so only first two digits remain; name that a new variable
    //13 digit number:
    int VisafirstTwoDigits13 = userInput - (userInput % 10^(11));
    //16 digit number:
    int VisafirstTwoDigits16 = userInput - (userInput % 10^(14));
    // what is the remainder of either new variable when divided by (4 * (10^12)) or (4 * (10^15))?
    int remainderZeroFour13 = VisafirstTwoDigits13 % (4 * (10^12));
    int remainderZeroFour16 = VisafirstTwoDigits16 % (4 * (10^15));
    if((remainderZeroFour13 != 0) || (remainderZeroFour16 != 0)){
        return false;
        }
    else{
        return true;
        }
}
