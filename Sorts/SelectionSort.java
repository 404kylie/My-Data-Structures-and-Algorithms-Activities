import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
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
						selectionSort(sortedArray); // Use Selection Sort
						System.out.println("Sorted array: " + Arrays.toString(sortedArray));
		}
		// SELECTION SORT METHOD
		    public static void selectionSort(int[] array) {
		        int n = array.length;
		        for (int i = 0; i < n - 1; i++) {
		            int minIndex = i; // Start with the first unsorted element
		            // Find the smallest number in the unsorted part
		            for (int j = i + 1; j < n; j++) {
		                if (array[j] < array[minIndex]) {
		                    minIndex = j; // Update minIndex if a smaller number is found
		                }
		            }
		            // Swap the smallest number with the first unsorted element
		            int temp = array[minIndex];
		            array[minIndex] = array[i];
		            array[i] = temp;
		        }
    }
}