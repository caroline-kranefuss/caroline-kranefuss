// A program to validate a credit card using longs

#include <cs50.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

//calling my functions at the beginning of the program
long getUserInput();
bool checkLength(long userInput);
bool checksum(long userInput);
bool checkType(long userInput);
bool mathToCheckAmex(long userInput);
bool mathToCheckMC(long userInput);
bool mathToCheckVisa(long userInput);
int getDigitAtPlace(long input, int digitPlace);

int main(void)
{
    //get user input
    long userInput = getUserInput();

    // check length
    bool isValid = checkLength(userInput);

    //check if it's a valid cc #
    if (isValid)
    {
        isValid = checksum(userInput);
    }

    //check starting number
    if (isValid)
    {
        isValid = checkType(userInput);
    }

    //if none of the above conditions are met, print INVALID
    if (!isValid)
    {
        printf("INVALID\n");
    }
}

//ask the user for a number; will continue to ask user until a valid number (a sequence of only digits) is given
long getUserInput()
{
    long userInput = get_long("Number: ");
    return userInput;
}

bool checkLength(long userInput)
{
    //these variables check the length of the user input
    //for example, if you divide a 13 digit number by 1,000,000,000,000, the result will be between 1 and 10 inclusive
    int thirteenDigits = userInput / (1000000000000.00);
    int fifteenDigits = userInput / (100000000000000.00);
    int sixteenDigits = userInput / (1000000000000000.00);
    return (thirteenDigits >= 1 && thirteenDigits <= 10) ||
           (fifteenDigits >= 1 && fifteenDigits <= 10) ||
           (sixteenDigits >= 1 && sixteenDigits <= 10);
}

bool checksum(long userInput)
{
    // these are counters for the sums we need
    int productsDigitsSum = 0;
    int otherDigitsSum = 0;

    // this calculates the sums we need by iterating through each digit
    for (int i = 1; powl(10.0, i) <= userInput * 10; i += 2)
    {
        // 10th, 1000th, etc place digit of the cc
        int digit = getDigitAtPlace(userInput, i);
        int doubledDigit = digit * 2;
        // doubledDigit will always be between 0 and 18, so no for loop needed
        int tens = doubledDigit / 10;
        int ones = doubledDigit % 10;
        // 1th, 100th, etc place digit of the cc
        int otherDigit = getDigitAtPlace(userInput, i - 1);

        // these are the counters in action
        productsDigitsSum += (tens + ones);
        otherDigitsSum += otherDigit;
    }

    // checking if our total sum's last digit is zero
    int totalSum = productsDigitsSum + otherDigitsSum;
    if (totalSum % 10 != 0)
    {
        return false;
    }
    else
    {
        return true;
    }
}

int getDigitAtPlace(long input, int digitPlace)
{
    // long modValue = powl(10.0, digitPlace + 1);
    // long divisorValue = powl(10.0, digitPlace);
    // long highValue = input % modValue;
    // int finalValue = highValue / divisorValue;
    //everything above here was a set of intermediate steps to slow down the process as i debugged; they are summarized below
    int finalValue = (input / (long)powl(10.0, digitPlace)) % 10;
    return finalValue;
}

//this function calls several functions which will be defined below
bool checkType(long userInput)
{
    if (mathToCheckAmex(userInput))
    {
        printf("AMEX\n");
        return true;
    }
    else if (mathToCheckMC(userInput))
    {
        printf("MASTERCARD\n");
        return true;
    }
    else if (mathToCheckVisa(userInput))
    {
        printf("VISA\n");
        return true;
    }
    else
    {
        return false;
    }
}

bool mathToCheckAmex(long userInput)
{
    //similar logic to checking if the input is 13 digits long
    //when an AMEX is divided by 10^13, the only numbers left (because in integer division, it cuts off anything after the ones place and doesn't round) will be 34 or 37
    int fourteenthAndFifteenthDigitAmex = userInput / (long) powl(10, 13);
    if (fourteenthAndFifteenthDigitAmex == 34
        || fourteenthAndFifteenthDigitAmex == 37)
    {
        return true;
    }
    else
    {
        return false;
    }
}

bool mathToCheckMC(long userInput)
{
    //similar logic to AMEX
    int fifteenthAndSixteenthDigitMC = userInput / (long) powl(10,14);
    if (fifteenthAndSixteenthDigitMC == 51
        || fifteenthAndSixteenthDigitMC == 52
        || fifteenthAndSixteenthDigitMC == 53
        || fifteenthAndSixteenthDigitMC == 54
        || fifteenthAndSixteenthDigitMC == 55)
    {
        return true;
    }
    else
    {
        return false;
    }
}

bool mathToCheckVisa(long userInput)
{
    int sixteenthDigitVisa = userInput / (long) powl(10, 15);
    int thirteenthDigitVisa = userInput / (long) powl(10, 12);
    if (sixteenthDigitVisa == 4 || thirteenthDigitVisa == 4)
    {
        return true;
    }
    else
    {
        return false;
    }
}
