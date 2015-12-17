import java.util.Scanner;

public class BoardAndLightSwitches {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		if (n < 5) {
			System.out.println(-1);
			return;
		} else {
			int ans = 0;
			while (true) {
				n = (n / 2) * (n - (n / 2));
				ans++;
				if (n >= 1000000000)
					break;
			}
			System.out.println(ans);
		}
	}
}
