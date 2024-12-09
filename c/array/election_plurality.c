// Simulating election plurality results

#include <cs50.h>
#include <stdio.h>
#include <string.h>

// Max number of candidates
#define MAX 9

// Candidates have name and vote count
typedef struct
{
    string name;
    int votes;
} candidate;

// Array of candidates
candidate candidates[MAX];

// Number of candidates
int candidate_count;

// Function prototypes
bool vote(string name);
void print_winner(void);

int main(int argc, string argv[])
{
    // Check for invalid usage
    if (argc < 2)
    {
        printf("Usage: plurality [candidate ...]\n");
        return 1;
    }

    // Populate array of candidates
    candidate_count = argc - 1;
    if (candidate_count > MAX)
    {
        printf("Maximum number of candidates is %i\n", MAX);
        return 2;
    }
    for (int i = 0; i < candidate_count; i++)
    {
        candidates[i].name = argv[i + 1];
        candidates[i].votes = 0;
    }

    int voter_count = get_int("Number of voters: ");

    // Loop over all voters
    for (int i = 0; i < voter_count; i++)
    {
        string name = get_string("Vote: ");

        // Check for invalid vote
        if (!vote(name))
        {
            printf("Invalid vote.\n");
        }
    }

    // Display winner of election
    print_winner();
}

// Update vote totals given a new vote
bool vote(string name)
{
    bool indicator = false;
    for (int i = 0; i < sizeof(candidates); i++)
    {
        if (strcmp(name, candidates[i].name) == 0)
        {
            candidates[i].votes++;
            indicator = true;
        }
    }
    return indicator;
}

// Print the winner (or winners) of the election
void print_winner(void)
{
    // Bubble sort the votes (smallest to largest)
    for (int i = 0; i < sizeof(candidates) - 1; i++)
    {
        bool swapped = false;
        for (int j = 0; j <= sizeof(candidates) - 2; j++)
        {
            candidate firstElement = candidates[j];
            candidate secondElement = candidates[j + 1];

            if (firstElement.votes < secondElement.votes)
            {
                candidates[j] = secondElement;
                candidates[j + 1] = firstElement;
                swapped = true;
            }
        }
        if (!swapped)
            break;
    }

    // Print the first candidate in the list
    int largestNumberOfVotes = candidates[0].votes;
    for (int i = 0; i < sizeof(candidates); i++)
    {
        int currentNumberOfVotes = candidates[i].votes;
        if (largestNumberOfVotes == currentNumberOfVotes)
        {
            // print first candidate
            printf("%s\n", candidates[i].name);
        }
        else
        {
            break;
        }
    }
    return;
}
