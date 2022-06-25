import java.util.*;

public class sort {
    
    //bubble sort
    public static int bubble (int list[], int length) {
        //runs through the list
        for (int i = 0; i < length - 1; i++) {
            //checks if a swap has occurred
            boolean swapped = false;
            //runs through the list to compare each value to the next one
            for (int j = 0; j < length - i - 1; j++) {
                //if the current value is greater than the next one, swap them
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    //set swapped to true
                    swapped = true;
                }
            }
            
            //if no swaps have occurred, then the algorithm is complete
            if (!swapped) {
                break;
            }
        }

        //bubble sort successful
        return 0;
    }

    //insertion sort
    public static int insertion (int list[], int length) {
        //runs through the list starting at index 1
        for (int index = 1; index < length; index++) {
            //stores the value to be compared
            int value = list[index];
            //stores the index of the value to be compared
            int j = index - 1;
            //compare value with each element on the leftside until it finds an element smaller than it
            while (j >= 0 && value < list[j]) {
                list[j + 1] = list[j];
                j--;
            }
            //insert the value into the correct position
            list[j + 1] = value;
        }

        //insertion sort successful
        return 0;
    }

    //sorting function for merge sort
    public static void mergeSort (int list[], int start, int middle, int end) {
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
    public static int merge (int list[], int start, int end) {

        //if the list is only one element long, it is already sorted
        if (start < end) {
            //calculate the middle value
            int middle = (start + end) / 2;

            //divie the list into smaller lists recursively
            sort.merge(list, start, middle);
            sort.merge(list, middle + 1, end);
            
            //merge the two halves
            sort.mergeSort(list, start, middle, end);
        }

        //merge sort successful
        return 0;
    }

    //function to put pivot element in the right place (partitioning the list)
    public static int partition (int list[], int left, int right) {

        //pivot element is the rightmost element
        int pivot = list[right];

        //pointer for finding greater element(s)
        int i = left - 1;

        //runs through the list, and compares each element to the pivot element
        for (int j = left; j < right; j++) {
            //if the element is smaller than the pivot element, move it to the left
            if (list[j] <= pivot) {
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        //swap the pivot element with the element at the rightmost position
        int temp = list[i + 1];
        list[i + 1] = list[right];
        list[right] = temp;

        //return the index of the pivot element
        return (i+1);
    }
    
    //quick sort
    public static int quick (int list[], int start, int end) {

        //if the list is only one element long, it is already sorted
        if (start < end) {
            //find the pivot element and put all elements < pivot on the left, and all elements > pivot on the right
            int pivot = sort.partition(list, start, end);
            
            //call the left and right halves of the list recursively
            sort.quick(list, start, pivot - 1);
            sort.quick(list, pivot + 1, end);
        }

        //quick sort successful
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
            sort.bubble(list, length);
        } else if (choice == 2) {
            sort.insertion(list, length);
        } else if (choice == 3) {
            sort.merge(list, 0, length - 1);
        } else {
            sort.quick (list, 0, length - 1);
        }

        //print sorted list
        System.out.print("Sorted list: ");
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("");

        stdin.close();

        System.out.println("SORTED");
    }
}