// Including any headers or libraries
#include <ctype.h>
#include <cs50.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

// Calling my functions at the beginning so main can run
int count_letters(string text);

int count_words(string text);

int count_sentences(string text);

int main(void)
{
    // Ask user for input
    string text = get_string("Text: ");

    int numberOfLetters = count_letters(text);

    int numberOfWords = count_words(text);

    int numberOfSentences = count_sentences(text);

    // Here begins the math for the CL index
    float L = (float)numberOfLetters * 100 / numberOfWords;

    float S = (float)numberOfSentences * 100 / numberOfWords;

    // I am making the index into a double so I can use the round function
    double index = 0.0588 * (float)L - 0.296 * (float)S - 15.8;

    // Round the result to the nearest integer
    int result = round(index);

    // Accounting for indices that are below or above 1 or 16
    if (result < 1)
    {
        printf("Before Grade 1\n");
    }
    else if (result > 16)
    {
        printf("Grade 16+\n");
    }
    // If it isn't below 1 or above 16, just print the result as the grade level
    else
    {
        printf("Grade %i\n", result);
    }
}

int count_letters(string text)
{
    int letters = 0;
    // Iterating over the length of the string, through each place i in the array
    for (int i = 0; i <= strlen(text); i++)
    {
        // If the char at point i in the array is alpha, add to the counter letters
        if (isalpha(text[i]))
        {
            letters++;
        }
    }
    return letters;
}

int count_words(string text)
{
    int spaces = 0;
    for (int i = 0; i <= strlen(text); i++)
    {
        if (isspace(text[i]))
        {
            spaces++;
        }
    }

    // Number of spaces is one fewer than the number of words
    return spaces + 1;
}

int count_sentences(string text)
{
    int sentences = 0;
    for (int i = 0; i <= strlen(text); i++)
    {
        if (text[i] == '.' || text[i] == '!' || text[i] == '?')
        {
            sentences++;
        }
    }
    return sentences;
}
