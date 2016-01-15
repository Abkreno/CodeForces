import java.util.Scanner;

public class GoodByeA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] l = sc.nextLine().split(" ");
		int a = Integer.parseInt(l[0]);
		if (l[2].equals("month")) {
			if (a == 31) {
				System.out.println(7);
			} else if (a == 30) {
				System.out.println(11);
			} else {
				System.out.println(12);
			}
		} else {
			if (a == 5 || a == 6) {
				System.out.println(53);
			} else {
				System.out.println(52);
			}
		}
	}
}
