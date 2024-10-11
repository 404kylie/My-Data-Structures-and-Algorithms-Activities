import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for the number of elements in the array
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Create an array with the specified size
        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");

        // Fill the array with user input
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
						int[] sortedArray = Arrays.copyOf(array, array.length);
						insertionSort(sortedArray); // Use Insertion Sort
						System.out.println("Sorted array: " + Arrays.toString(sortedArray));
		}
		// INSERTION SORT METHOD
		    public static void insertionSort(int[] array) {
		        int n = array.length;
		        for (int i = 1; i < n; ++i) {
		            int key = array[i]; // The number to be placed in the correct spot
		            int j = i - 1;

		            // Move larger numbers up in the array
		            while (j >= 0 && array[j] > key) {
		                array[j + 1] = array[j];
		                j--;
		            }
		            array[j + 1] = key; // Place the key in its correct position
		        }
    }
}
