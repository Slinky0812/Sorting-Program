import java.util.*;

public class sort {

    public static void swap (int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    
    public static int bubble (int list[], int length) {
        return 0;
    }

    public static int insertion (int list[], int length) {
        return 0;
    }

    public static void mergeSort (int list[], int start, int middle, int end) {

    }

    public static int merge (int list[], int start, int end) {
        return 0;
    }

    public static int partition (int list[], int left, int right) {
        return 0;
    }
    
    public static int quick (int list[], int start, int end) {
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