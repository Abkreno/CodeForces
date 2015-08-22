import java.util.Scanner;

public class EquidistantString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		char[] t = sc.nextLine().toCharArray();
		StringBuffer sb = new StringBuffer();
		boolean toggle = false;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == t[i]) {
				sb.append(s[i] + "");
			} else {
				if (toggle) {
					sb.append(s[i] + "");
				} else {
					sb.append(t[i] + "");
				}
				toggle = !toggle;
			}
		}
		if (toggle) {
			System.out.println("impossible");
			return;
		}
		System.out.println(sb);
	}
}
