class BinarySearch {
  int binarySearch(int array[], int x, int low, int high) {

    if (high >= low) {
      int mid = low + (high - low) / 2;


      if (x == array[mid])
        return mid;


      if (x > array[mid])
        return binarySearch(array, x, mid + 1, high);


      return binarySearch(array, x, low, mid - 1); // return value
    }

    return -1; // return value
  }

  public static void main(String args[]) {
    BinarySearch ob = new BinarySearch();
    int array[] = { 3, 4, 5, 6, 7, 8, 9 }; // my array
    int n = array.length;
    int x = 9;
    int result = ob.binarySearch(array, x, 0, n - 1);
    if (result == -1) // if else
      System.out.println("Not found");
    else
      System.out.println("Element found at index " + result);
  }
}