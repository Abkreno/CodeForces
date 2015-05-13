import java.util.Scanner;

public class MrKitayutaGift {
	static String word, temp;

	static boolean checkPalind() {
		int j = temp.length() - 1;
		for (int i = 0; i < j; i++) {
			if (temp.charAt(i) != temp.charAt(j))
				return false;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		word = sc.next();
		String abc = "abcdefghijklmnopqrstuvwxyz";
		boolean found = false;
		loop: for (int i = 0; i < abc.length(); i++) {
			char curr = abc.charAt(i);
			for (int j = 0; j < word.length(); j++) {
				String beg = word.substring(0, j);
				String end = word.substring(j);
				temp = beg + curr + end;
				if (checkPalind()) {
					System.out.println(temp);
					found = true;
					break loop;
				}
			}
			temp = word + curr;
			if (checkPalind()) {
				System.out.println(temp);
				found = true;
				break loop;
			}
		}
		if (!found)
			System.out.println("NA");
	}

}
