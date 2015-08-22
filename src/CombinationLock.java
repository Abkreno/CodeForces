import java.util.Scanner;

public class CombinationLock {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		char[] a = sc.nextLine().toCharArray();
		char[] b = sc.nextLine().toCharArray();
		int ans = 0;
		int curr;
		for (int i = 0; i < a.length; i++) {
			curr = Math.min(Math.abs(a[i] - b[i]), (a[i] - '0') + 1 + 9
					- (b[i] - '0'));
			curr = Math.min(curr, 9 - (a[i] - '0') + 1 + (b[i] - '0'));
			ans += curr;
		}
		System.out.println(ans);
	}
}
