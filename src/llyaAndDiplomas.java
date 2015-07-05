import java.util.Scanner;

public class llyaAndDiplomas {
	static int ans2, ans3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min1 = sc.nextInt();
		int max1 = sc.nextInt();
		int min2 = sc.nextInt();
		int max2 = sc.nextInt();
		int min3 = sc.nextInt();
		int max3 = sc.nextInt();
		int lo1 = min1;
		int hi1 = max1;
		while (lo1 < hi1) {
			int mid = (lo1 + hi1) / 2;
			if (mid <= n && check(n - mid, min2, max2, min3, max3)) {
				lo1 = mid + 1;
			} else {
				hi1 = mid - 1;
			}
		}
		if (lo1 > max1 || !check(n - lo1, min2, max2, min3, max3)) {
			lo1--;
			check(n - lo1, min2, max2, min3, max3);
		}
		System.out.println(lo1 + " " + ans2 + " " + ans3);
	}

	private static boolean check(int n, int min2, int max2, int min3, int max3) {
		boolean found = false;
		for (int i = max2; i >= min2; i--) {
			if (i <= n) {
				ans2 = i;
				ans3 = Math.min(n - i, max3);
				if (ans3 < min3)
					continue;
				found = true;
				break;
			}
		}

		return found;
	}

}
