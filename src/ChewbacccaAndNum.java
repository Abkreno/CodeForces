import java.util.Scanner;

public class ChewbacccaAndNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] num = sc.nextLine().toCharArray();
		for (int i = 0; i < num.length; i++) {
			int curr = num[i] - '0';
			System.out.print(9 - curr == 0 &&i==0? curr : Math.min(curr, 9 - curr));
		}
		System.out.println();
	}
}
