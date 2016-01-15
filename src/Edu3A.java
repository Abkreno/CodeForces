import java.util.Arrays;
import java.util.Scanner;

public class Edu3A {
	static class Num implements Comparable<Num> {

		@Override
		public int compareTo(Num arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		int res = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (m <= 0) {
				break;
			}
			m -= nums[i];
			res++;
		}
		System.out.println(res);
	}
}
