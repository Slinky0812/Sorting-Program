import java.util.*;

public class sort {

    //swap function
    public static void swap (int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    
    //bubble sort
    public static int bubble (int[] list, int length) {
        //run variable to allow the algorithm to keep going through the list, until it goes through the list with no swaps
        boolean run = true;
        while (run) {
            //increments whenever a swap is made
            int count = 0;
            //runs through the list
            for (int i = 0; i < length; i++) {
                //swap if the next value is greater than the current one
                if (list[i] > list[i+1]) {
                    swap(list[i], list[i+1]);

                    //increment count
                    count += 1;
                }
            }
            //if count is 0, then no swaps have been made, meaning algorithm is complete
            if (count == 0) {
                run = false;
            }
        }

        //bubble sort successful
        System.out.println("BUBBLED");
        return 0;
    }

    //insertion sort
    public static int insertion (int[] list, int length) {
        //new list to store the sorted numbers
        int[] sorted = new int[length];
        //stores the first variable of the list into the sorted list
        sorted[0] = list[0];
        //runs through the list
        for (int i = 1; i < length; i++) {
            //stores the next variable of the list into the sorted list
            sorted[i] = list[i];
            //count variable to change position of data in sorted list
            int count = i;

            //runs through the sorted list
            for (int j = 1; j <= i; j++) {
                //swap values
                if (sorted[count] < sorted[i-j]) {
                    swap(sorted[i-j], sorted[count]);
                    //decrease count
                    count -= 1;
                //no swap needed
                } else {
                    break;
                }
            }
        }

        //insertion sort successful
        System.out.println("INSERTED");
        return 0;
    }

    //sorting function for merge sort
    public static void mergeSort (int[] list, int start, int middle, int end) {
        //calculate length of lists to be put together
        int length1 = middle - start + 1;
        int length2 = end - middle;

        //create temporary lists
        int[] a1 = new int[length1];
        int[] a2 = new int[length2];

        //copy data into temporary lists
        for (int i = 0; i < length1; i++) {
            a1[i] = list[start + i];
        }
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
            //if a1 is smaller, copy it to the main list
            if (a1[i] < a2[j]) {
                list[k] = a1[i];
                i++;
            } else {
                //if a2 is smaller, copy it to the main list
                list[k] = a2[j];
                j++;
            }
            k++;
        }

        //copy the rest of a1 to the main list
        while (i < length1) {
            list[k] = a1[i];
            i++;
            k++;
        }

        //copy the rest of a2 to the main list
        while (j < length2) {
            list[k] = a2[j];
            j++;
            k++;
        }

    }

    //merge sort
    public static int merge (int[] list, int start, int end) {

        //if the list is only one element long, it is already sorted
        if (start < end) {
            //calculate the middle value
            int middle = (start + end) / 2;

            //divie the list into smaller lists recursively
            merge(list, start, end);
            merge(list, middle + 1, end);
            
            //merge the two halves
            mergeSort(list, start, middle, end);
        }

        //merge sort successful
        System.out.println("MERGED");
        return 0;
    }

    //function to put pivot element in the right place (partitioning the list)
    public static int partition (int[] list, int left, int right) {

        //pivot element is the rightmost element
        int pivot = list[right];

        //pointer for finding greater element(s)
        int i = left - 1;

        //runs through the list, and compares each element to the pivot element
        for (int j = left; j < right; j++) {
            //if the element is smaller than the pivot element, move it to the left
            if (list[j] < pivot) {
                i++;
                swap(list[i], list[j]);
            }
        }

        //swap the pivot element with the element at the rightmost position
        swap(list[i+1], list[right]);

        //return the index of the pivot element
        return (i+1);
    }
    
    //quick sort
    public static int quick (int[] list, int start, int end) {

        //if the list is only one element long, it is already sorted
        if (start < end) {
            //find the pivot element and put all elements < pivot on the left, and all elements > pivot on the right
            int pivot = partition(list, start, end);
            
            //call the left and right halves of the list recursively
            quick(list, start, pivot - 1);
            quick(list, pivot + 1, end);
        }

        //quick sort successful
        System.out.println("QUICK");
        return 0;
    }
    
    //main function
    public static void main(String args[]) {

        //create scanner class
        Scanner stdin = new Scanner (System.in);
        
        //find the length of list
        int length;
        System.out.print("Enter the length of the list: ");
        length = stdin.nextInt();

        //create list and input values
        int[] list = new int[length];
        System.out.print("Enter the list you want sorted: ");
        for (int i = 0; i < length; i++) {
            list[i] = stdin.nextInt();
            //if user puts less elements than length
        }



        //choose which sorting algorithm to use
        int choice;
        System.out.println("Sorting Options:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Quick Sort");
        System.out.print("Please choose one of the options below to sort your list: ");
        choice = stdin.nextInt();

        //calling chosen sorting algorithm
        if (choice < 1 || choice > 4) {
            System.out.println("Choice out of bounds");
            System.exit(1);
        } else if (choice == 1) {
            bubble(list, length);
        } else if (choice == 2) {
            insertion(list, length);
        } else if (choice == 3) {
            merge(list, 0, length - 1);
        } else {
            quick (list, 0, length - 1);
        }

        System.out.println("SORTED");
    }
}