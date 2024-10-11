import java.util.Scanner;
class palindrome {
	public static boolean palindrome(String word) {
		word = word.toLowerCase();
		String reversed = new StringBuilder (word).reverse().toString();
		return word.equals(reversed);
		}
		public static void main(String [] args){
			String [] words = {"madam", "atoyota", "rabar", "pogi"};

			for (String word : words){
				if (palindrome(word)) {
					System.out.println( "  " +word+ " is a Palindrome");
				}
				else {
					System.out.println( "  " +word+ " is not a Palindrome");
				}
}

			}


			}