import java.util.Scanner;

public class Inbox {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		char[] s = new char[n];
		int one = -1;
		String[] l = sc.nextLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			s[i] = l[i].charAt(0);
			if (one == -1 && s[i] == '1')
				one = i;
		}
		int ans = 0;
		if (one != -1) {
			ans++;
			int conscZeros = 0;
			for (int i = one + 1; i < n; i++) {
				if (s[i] == '0')
					conscZeros++;
				else {
					ans += Math.min(2, conscZeros + 1);
					conscZeros = 0;
				}
			}
		}
		System.out.println(ans);
	}
}
