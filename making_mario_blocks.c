#include <cs50.h>
#include <stdio.h>

int getUserInput();
void printPyramid(int height);
void printNChars(int n, char myChar);

int main(void)
{
    //get user input
    int userInput = getUserInput();
    //print pyramid based on input
    printPyramid(userInput);
}


int getUserInput()
{
    int userInput;
    do
    {
        userInput = get_int("Height: ");
    }
    while (!(userInput >= 1 && userInput <= 8));

    return userInput;
}

void printPyramid(int height)
{
    for (int i = 1; i <= height; i++)
    {
        //figure out number spaces
        int numSpace = height - i;
        //figure out number hashes
        int numHash = i;
        //print all fancy!
        printNChars(numSpace, ' ');
        printNChars(numHash, '#');
        printNChars(2, ' ');
        printNChars(numHash, '#');
        printf("\n");
    }

}

void printNChars(int n, char myChar)
{
    for (int i = 0; i < n; i++)
    {
        printf("%c", myChar);
    }
}
