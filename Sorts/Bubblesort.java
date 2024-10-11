import java.util.Arrays;

class Bubblesort {

  // perform the bubble sort
  static void bubbleSort(int array[]) {
    int size = array.length;

    // loop to access each array element
    for (int i = 0; i < size - 1; i++)

      // loop to compare array elements
      for (int j = 0; j < size - i - 1; j++)

        // compare two adjacent elements
        if (array[j] > array[j + 1]) {

          // swapping elements when its not in the right order
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
  }

  public static void main(String args[]) {

    int[] data = { 99, 299, 45, 0, 111, -6, 29 }; // data in the array

    // call method using class name, without this method it won't sort into ascending order**


    System.out.println("Sorted Array in Ascending Order:"+ Arrays.toString(data)); // Prints the Sorted Array in Ascending Order
  }
}