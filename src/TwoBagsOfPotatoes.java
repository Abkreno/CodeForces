import java.util.Scanner;

public class TwoBagsOfPotatoes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		long k = sc.nextInt();
		int n = sc.nextInt();
		long curr;
		StringBuffer ans = new StringBuffer();
		for (long i = ((y / k) + 1);; i++) {
			curr = i * k;
			if (curr > n)
				break;
			ans.append(curr - y + " ");
		}
		if (ans.length() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
}
