import java.util.Scanner;

public class incARG {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char[] in = sc.nextLine().toCharArray();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (in[i] == '0') {
				in[i] = '1';
				ans++;
				break;
			} else {
				in[i] = '0';
				ans++;
			}
		}
		System.out.println(ans);
	}
}
