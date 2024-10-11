	import java.util.Arrays;
	import java.util.Scanner;

	public class ArrayOperations {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter the number of elements: ");
			int n = sc.nextInt();

			int[] array = new int[n];
			System.out.println("Enter the elements of the array: ");
			for (int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}

			// Linear Search
			System.out.print("Enter the value to search using Linear Search: ");
			int target = sc.nextInt();
			int linearResult = linearSearch(array, target);
			System.out.println("Linear Search result: " + (linearResult != -1 ? "Found at index " + linearResult : "Not found"));

			// Binary Search (Sorted Array)
			Arrays.sort(array);
			System.out.println("Sorted array for binary search: " + Arrays.toString(array));
			System.out.print("Enter the value to search using Binary Search: ");
			target = sc.nextInt();
			int binaryResult = binarySearch(array, target, 0, array.length - 1);
			System.out.println("Binary Search result: " + (binaryResult != -1 ? "Found at index " + binaryResult : "Not found"));

			// Sorting
			System.out.println("Choose a sorting algorithm:");
			System.out.println("1. Bubble Sort\n2. Insertion Sort\n3. Selection Sort\n4. Merge Sort\n5. Quick Sort");
			int choice = sc.nextInt();

			int[] sortedArray = Arrays.copyOf(array, array.length);
			switch (choice) {
				case 1 -> bubbleSort(sortedArray);
				case 2 -> insertionSort(sortedArray);
				case 3 -> selectionSort(sortedArray);
				case 4 -> mergeSort(sortedArray, 0, sortedArray.length - 1);
				case 5 -> quickSort(sortedArray, 0, sortedArray.length - 1);
				default -> System.out.println("Invalid choice");
			}

			System.out.println("Sorted array: " + Arrays.toString(sortedArray));
		}

		// 1. Linear Search
		public static int linearSearch(int[] array, int target) {
			// Implement linear search here
			for (int i = 0; i < array.length; i++) {
						if (array[i] == target) {
							return i;
						}
			}

			return -1; // Placeholder
		}

		// 2. Binary Search (works only on sorted arrays)
		public static int binarySearch(int[] array, int target, int low, int high) {
			// Implement binary search here
			if (high >= low) {
						int mid = low + (high - low) / 2;

						if (array[mid] == target) {
							return mid;
						}
						if (array[mid] > target) {
							return binarySearch(array, target, low, mid - 1);
						}
						return binarySearch(array, target, mid + 1, high);
			}
			return -1; // Placeholder
		}

		// 3. Bubble Sort
		public static void bubbleSort(int[] array) {
			// Implement bubble sort here
			int n = array.length;
					for (int i = 0; i < n - 1; i++) {
						for (int j = 0; j < n - i - 1; j++) {
							if (array[j] > array[j + 1]) {
								// swap array[j] and array[j+1]
								int temp = array[j];
								array[j] = array[j + 1];
								array[j + 1] = temp;
							}
						}
			}
		}

		// 4. Insertion Sort
		public static void insertionSort(int[] array) {
			// Implement insertion sort here
			int n = array.length;
					for (int i = 1; i < n; ++i) {
						int key = array[i];
						int j = i - 1;

						while (j >= 0 && array[j] > key) {
							array[j + 1] = array[j];
							j--;
						}
						array[j + 1] = key;
			}
		}

		// 5. Selection Sort
		public static void selectionSort(int[] array) {
			// Implement selection sort here
			int n = array.length;
					for (int i = 0; i < n - 1; i++) {
						int minIndex = i;
						for (int j = i + 1; j < n; j++) {
							if (array[j] < array[minIndex]) {
								minIndex = j;
							}
						}
						// swap the found minimum element with the first element
						int temp = array[minIndex];
						array[minIndex] = array[i];
						array[i] = temp;
			}
		}

		// 6. Merge Sort
		public static void mergeSort(int[] array, int left, int right) {
			// Implement merge sort here
			if (left < right) {
						int mid = (left + right) / 2;
						mergeSort(array, left, mid);
						mergeSort(array, mid + 1, right);
						merge(array, left, mid, right);
			}
		}

		public static void merge(int[] array, int left, int mid, int right) {
			// Implement merging logic here
			int n1 = mid - left + 1;
					int n2 = right - mid;

					int[] L = new int[n1];
					int[] R = new int[n2];

					for (int i = 0; i < n1; i++) L[i] = array[left + i];
					for (int j = 0; j < n2; j++) R[j] = array[mid + 1 + j];

					int i = 0, j = 0, k = left;
					while (i < n1 && j < n2) {
						if (L[i] <= R[j]) {
							array[k++] = L[i++];
						} else {
							array[k++] = R[j++];
						}
					}

					while (i < n1) array[k++] = L[i++];
			while (j < n2) array[k++] = R[j++];
		}

		// 7. Quick Sort
		public static void quickSort(int[] array, int low, int high) {
			// Implement quick sort here
			if (low < high) {
						int pi = partition(array, low, high);
						quickSort(array, low, pi - 1);
						quickSort(array, pi + 1, high);
			}
		}

		public static int partition(int[] array, int low, int high) {
			// Implement partition logic here
	int pivot = array[high];
			int i = (low - 1);

			for (int j = low; j < high; j++) {
				if (array[j] < pivot) {
					i++;
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}

			int temp = array[i + 1];
			array[i + 1] = array[high];
			array[high] = temp;

			return i + 1; //Placeholder
		}
	}

