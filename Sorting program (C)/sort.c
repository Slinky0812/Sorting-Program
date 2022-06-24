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
        merge(list, 0, length-1);
    } else {
        quick(list, 0, length - 1);
    }

    //print sorted list
    for (int i = 0; i < length; i++) {
        printf("%d ", list[i]);
    }
    printf("\n");


    printf("SORTED\n");
    return 0;
}

//swap values function
void swap (int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

//bubble sort
int bubble (int list[], int length) {

    //run variable to allow the algorithm to keep running until there are no swaps
    int run = 1;
    while (run == 1) {
        //increments whenever a swap is made
        int count = 0;
        //runs through the list
        for (int i = 0; i < length; i++) {
               //swap if the next value is greater than the current one
                if (list[i] > list[i+1]) {
                    swap (&list[i], &list[i+1]);

                    //increment count
                    count += 1;
                }
        }
        //if count is 0, no swaps have been made, meaning algorithm is complete.
        if (count == 0) {
            run = 0;
        }
    }

    //bubble sort successful
    return 0;
}

//insertion sort
int insertion (int list[], int length) {
    //new list to store the sorted numbers
    int sorted[length];
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
                swap (&sorted[i-j], &sorted[count]);
                //decrease count
                count -= 1;
            //no swap needed
            } else {
                break;
            }
        }
    }

    //insertion sort successful
    return 0;
}

//sorting function for merge sort
void mergeSort (int list[], int start, int middle, int end) {

    //calculate the length of the lists to be put together
    int length1 = middle - start + 1;
    int length2 = end - middle;

    //create temp lists
    int a1[length1];
    int a2[length2];

    //put values at the beginning of the list into a1
    for (int i = 0; i < length1; i++) {
        a1[i] = list[start + i];
    }
    //put values from the middle of the list into a2
    for (int j = 0; j < length2; j++) {
        a2[j] = list[middle + 1 + j];
    }

    //index of a1
    int i = 0;
    //index of a2
    int j = 0;
    //index of main list
    int k = start;

    //runs until we reach the end of either a1 or a2
    while (i < length1 && j < length2) {
        //picks the smaller value out of either a1 or a2, and puts it into the list
        if (a1[i] <= a2[j]) {
            list[k] = a1[i];
            //increment a1 counter
            i+=1; 
        } else {
            list[k] = a2[j];
            //increment a2 counter
            j+=1;
        }
        //increment main counter
        k+=1;
    }

    //once we reach the end of either a1 or a2, put the remaining elements from a1 into list
    while (i < length1) {
        list[k] = a1[i];
        i += 1;
        k += 1;
    }

    //put the remaining elements of a2 into the list
    while (j < length2) {
        list[k] = a2[j];
        j += 1;
        k += 1;
    }

}

//merge sort
int merge (int list[], int start, int end) {

    //if list isn't of length 1
    if (start < end) {
        //calculate middle value
        int middle = (start + (end-1)) / 2;
        //divide the list into 2 lists recursively
        merge(list, start, middle);
        merge(list, middle + 1, end);

        //call the sorting function
        mergeSort(list, start, middle, end);
    }

    //merge sort successful
    return 0;
}

//function to put the pivot element in the right place (partitioning the list)
int partition (int list[], int left, int right) {

    //select the rightmost element of the list as the pivot
    int pivot = list[right];

    //pointer for finding greater element(s)
    int i = left - 1;

    //runs through the list, and compares them with the pivot
    for (int j = left; j < right; j++) {
        //if less than pivot, swap with element pointed at by i
        if (list[j] <= pivot) {
            i+=1;
            swap(&list[i], &list[j]);
        }
    }

    //swap the pivot element with element at the rightmost position
    swap (&list[i+1], &list[right]);

    //return the point of partition
    return (i+1);
}

//quick sort
int quick (int list[], int start, int end) {

    if (start < end) {
        //find the pivot element and put all elements < pivot on the left, and all elements > pivot on the right
        int pivot = partition(list, start, end);

        //call the left side of the pivot recursively
        quick (list, start, pivot - 1);
        //call the right side of the pivot recursively
        quick (list, pivot + 1, end);
    }

    //quick sort successful
    return 0;
}