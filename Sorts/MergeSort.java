import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
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
		mergeSort(sortedArray, 0, sortedArray.length - 1); // Use Merge Sort
	System.out.println("Sorted array: " + Arrays.toString(sortedArray));
		}

	// MERGE SORT METHOD
	    public static void mergeSort(int[] array, int left, int right) {
	        if (left < right) {
	            int mid = (left + right) / 2; // Find the middle
	            // Sort the two halves
	            mergeSort(array, left, mid);
	            mergeSort(array, mid + 1, right);
	            merge(array, left, mid, right); // Merge the sorted halves
	        }
	    }

	    // Helper method to merge two sorted parts
	    public static void merge(int[] array, int left, int mid, int right) {
	        // Sizes of the two parts to merge
	        int n1 = mid - left + 1;
	        int n2 = right - mid;

	        // Temporary arrays
	        int[] L = new int[n1];
	        int[] R = new int[n2];

	        // Copy data into temporary arrays
	        for (int i = 0; i < n1; i++) L[i] = array[left + i];
	        for (int j = 0; j < n2; j++) R[j] = array[mid + 1 + j];

	        // Merge the temporary arrays back into the original array
	        int i = 0, j = 0, k = left;
	        while (i < n1 && j < n2) {
	            if (L[i] <= R[j]) {
	                array[k++] = L[i++]; // If L[i] is smaller, add it to the array
	            } else {
	                array[k++] = R[j++]; // If R[j] is smaller, add it to the array
	            }
	        }

	        // Add remaining elements from L[] if any
	        while (i < n1) array[k++] = L[i++];
	        // Add remaining elements from R[] if any
	        while (j < n2) array[k++] = R[j++];
    }
}