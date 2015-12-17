import java.util.Scanner;

public class TheChildAndSet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int limit = sc.nextInt();
		int c = 0;
		int bit;
		StringBuffer ans = new StringBuffer();
		int mask = 0;
		for (int i = limit; i > 0; i--) {
			bit = Integer.lowestOneBit(i);
			if (bit + mask <= sum) {
				mask += bit;
				c++;
				ans.append(i + " ");
			}
		}

		if (mask != sum) {
			System.out.println(-1);
		} else {
			System.out.println(c);
			System.out.println(ans);
		}
	}
}