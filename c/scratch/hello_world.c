#include <stdio.h>
#include <cs50.h>

int main(void)
{
    string name = get_string("What's your name? "); // sks user for their name
    printf("Hello, %s\n", name); // Prints Hello, {user's name}
}
