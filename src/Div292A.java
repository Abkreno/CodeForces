import java.util.Scanner;

public class Div292A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int dist = sc.nextInt();
		int total = Math.abs(x) + Math.abs(y);
		if (dist < total) {
			System.out.println("No");
		} else {
			int dif = dist - total;
			if (dif % 2 == 0)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
