import java.util.Arrays;
import java.util.Scanner;

public class CandyBoxes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[4];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		if (n == 0) {
			System.out.println("YES\n1\n1\n3\n3");
		} else if (n == 1) {
			System.out.println("YES");
			System.out.println(a[0] + "\n" + (3 * a[0]) + "\n" + (3 * a[0]));
		} else if (n == 2) {
			if (a[0] > a[1]) {
				int tmp = a[0];
				a[0] = a[1];
				a[1] = tmp;
			}
			for (int i = 1; i <= 1000000; i++) {
				a[2] = i;
				if (checkThree(a)) {
					System.out.println("YES");
					System.out.println(a[2]);
					System.out.println(a[3]);
					return;
				}
			}
			System.out.println("NO");
		} else if (n == 3) {
			for (int i = 1; i <= 1000000; i++) {
				a[3] = i;
				if (check(a)) {
					System.out.println("YES");
					System.out.println(a[3]);
					return;
				}
			}
			System.out.println("NO");

		} else {
			if (check(a))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	private static boolean checkThree(int[] a) {
		int sum1 = a[1] + a[2];
		if (sum1 % 2 != 0)
			return false;
		a[3] = (sum1 / 2) + a[0];
		return check(a);
	}

	private static boolean check(int[] arr) {
		int a[] = arr.clone();
		Arrays.sort(a);
		int sum1 = a[0] + a[1] + a[2] + a[3];
		int sum2 = a[1] + a[2];
		if (sum1 % 4 == 0 && sum2 % 2 == 0 && sum1 / 4 == sum2 / 2
				&& sum2 / 2 == a[3] - a[0]) {
			return true;
		}
		return false;

	}
}
