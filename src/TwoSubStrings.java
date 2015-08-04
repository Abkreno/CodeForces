import java.util.Scanner;

public class TwoSubStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		boolean ab = false;
		boolean ba = false;
		for (int i = 0; i < s.length - 1; i++) {
			if (s[i] == 'A' && s[i + 1] == 'B') {
				if (ba) {
					System.out.println("YES");
					return;
				}
				ab = true;
				if (i + 2 < s.length && s[i + 2] == 'A') {
					ba = true;
					i += 2;
				} else {
					i++;
				}
			} else if (s[i] == 'B' && s[i + 1] == 'A') {
				if (ab) {
					System.out.println("YES");
					return;
				}
				ba = true;
				if (i + 2 < s.length && s[i + 2] == 'B') {
					ab = true;
					i += 2;
				} else {
					i++;
				}
			}
		}
		System.out.println("NO");
	}
}
