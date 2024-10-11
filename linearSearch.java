import java.util.Arrays;
import java.util.Scanner;

public class linearSearch {
    public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			int [] nums = {2,12,15,11,7,19,45};
			int target = 11;
			System.out.println(search(nums, target ));
		}
		static int search (int [] nums, int target) {
			for (int index = 0; index < nums.length; index++) { // for loop
				if (nums[index] == target){
				return index; // return value
			}

				}
				return -1; // return value
	}
}