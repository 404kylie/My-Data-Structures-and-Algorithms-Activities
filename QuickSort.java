import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
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
			quickSort(sortedArray, 0, sortedArray.length - 1); // Use Quick Sort
			System.out.println("Sorted array: " + Arrays.toString(sortedArray));
		}
        // QUICK SORT METHOD
	    public static void quickSort(int[] array, int low, int high) {
	        if (low < high) {
	            // Partitioning index
	            int pi = partition(array, low, high);
	            // Sort the parts before and after the partition
	            quickSort(array, low, pi - 1);
	            quickSort(array, pi + 1, high);
	        }
	    }

	    // Partitioning method for Quick Sort
	    public static int partition(int[] array, int low, int high) {
	        int pivot = array[high]; // Pivot element
	        int i = (low - 1); // Index of smaller element

	        // Rearrange the array by placing smaller numbers before the pivot
	        for (int j = low; j < high; j++) {
	            if (array[j] < pivot) {
	                i++;
	                // Swap array[i] and array[j]
	                int temp = array[i];
	                array[i] = array[j];
	                array[j] = temp;
	            }
	        }

	        // Swap the pivot element to its correct position
	        int temp = array[i + 1];
	        array[i + 1] = array[high];
	        array[high] = temp;

	        return i + 1; // Return the index of the pivot
	    }
}