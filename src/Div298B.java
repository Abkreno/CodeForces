import java.util.Scanner;

public class Div298B {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		int t = sc.nextInt();
		int d = sc.nextInt();
		long ans = v2;
		for (int i = 0; i < t - 1; i++) {
			ans += v1;
			if (v1 <= v2) {
				v1 += d;
			} else {
				if (v1 - v2 == (t - i - 2) * d) {

				} else {
					v1 = Math.min((t - i - 2) * d + v2, v1 + d);
				}
			}
		}
		System.out.println(ans);
	}
}
