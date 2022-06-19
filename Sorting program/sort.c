#include <stdio.h>
#include <stdlib.h>
#include "sort.h"

int main(int argc, char **argv) {

    //check only 1 argument has been given
    if (argc != 1) {
        printf("Bad Arg Count\n");
        return 1;
    }

    //find out the length of the list
    int length;
    printf("Enter the length of the list: ");
    scanf("%d", &length);

    //create list and store given values
    int list[length]; 
    printf("Enter the list you want sorted: ");
    for (int i = 0; i < length; i++) {
        scanf("%d", &list[i]);
    }

    // for (int i = 0; i < length; i++) {
    //     printf("%d  ", list[i]);
    // }
    // printf("\n");

    //Choosing which sorting algorithm to use
    int choice;
    printf("Sorting Options:\n");
    printf("1. Bubble Sort\n");
    printf("2. Insertion Sort\n");
    printf("3. Merge Sort\n");
    printf("4. Quick Sort\n");
    printf("Please choose one of the options below to sort your list: ");
    scanf("%d", &choice);

    //calling the chosen sorting algorithm
    if (choice < 1 || choice > 4) {
        printf("Choice out of bounds\n");
        return 1;
    } else if (choice == 1) {
        bubble(list, length);
    } else if (choice == 2) {
        insertion(list, length);
    } else if (choice == 3) {
        merge(list, length);
    } else {
        quick(list, length);
    }

    printf("SORTED\n");
    return 0;
}

//bubble sort
int bubble (int list[], int length) {

    //run variable to allow the algorithm to keep running until there are no swaps
    int run = 1;
    while (run == 1) {
        //increments whenever a swap is made
        int count = 0;
        //stores the value of a variable being swapped
        int temp;
        //runs through the list
        for (int i = 0; i < length; i++) {
               //swap if the next value is greater than the current one
                if (list[i] > list[i+1]) {
                    temp = list[i];
                    list[i] = list[i+1];    
                    list[i+1] = temp;
                    //increment count
                    count += 1;
                }
        }
        //if count is 0, no swaps have been made, meaning algorithm is complete.
        if (count == 0) {
            run = 0;
        }
    }

    //print sorted list
    for (int i = 0; i < length; i++) {
        printf("%d\n", list[i]);
    }
    //bubble sort successful
    return 0;
}

//insertion sort
int insertion (int list[], int length) {
    //new list to store the sorted numbers
    int sorted[length];
    //swap variable
    int temp;
    //stores the first variable of the list into the sorted list
    sorted[0] = list[0];

    //runs through the list
    for (int i = 1; i < length; i++) {
        //store the data into the sorted list
        sorted[i] = list[i];
        //count variable to change position of data in sorted list
        int count = i;
        
        //runs through the sorted list
        for (int j = 1; j <= i; j++) {
            //swap values
            if (sorted[count] < sorted[i-j]) {
                temp = sorted[i-j];
                sorted[i-j] = sorted[count];    
                sorted[count] = temp;
                //decrease count
                count -= 1;
            //no swap needed
            } else {
                break;
            }
        }
    }

    //print sorted list
    for (int i = 0; i < length; i++) {
        printf("%d\n", sorted[i]);
    }
    //insertion sort successful
    return 0;
}

//merge sort
int merge (int list[], int length) {
    printf("merged\n");
    return 0;
}

//quick sort
int quick (int list[], int length) {
    printf("quick\n");
    return 0;
}