import java.util.Scanner;

public class FittingBoxes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x[] = new int[2];
		int y[] = new int[2];
		x[0] = sc.nextInt();
		x[1] = sc.nextInt();
		y[0] = sc.nextInt();
		y[1] = sc.nextInt();
		for (int i = 0; i < y.length; i++) {
			for (int j = 0; j < x.length; j++) {
				if (test(x[i], x[1 - i], y[j], y[1 - j])) {
					System.out.println("Yes");
					return;
				}
				if (test(y[i], y[1 - i], x[j], x[1 - j])) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}

	private static boolean test(int i, int j, int k, int l) {
		if (i <= k && j <= l)
			return true;
		return false;
	}

}
