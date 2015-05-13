package A2_Div2_C;

import java.util.Scanner;

public class HackingSypher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] num = sc.nextLine().toCharArray();
		long a = sc.nextLong();
		long b = sc.nextLong();
		long[] suf = new long[num.length];
		long[] powOfTen = new long[suf.length];
		powOfTen[0] = 1;
		for (int i = 1; i < powOfTen.length; i++) {
			powOfTen[i] = (powOfTen[i - 1] * 10) % b;
		}
		suf[suf.length - 1] = (num[suf.length - 1] - '0') % b;
		for (int i = suf.length - 2; i >= 0; i--) {
			long p = powOfTen[(suf.length - 1) - i];
			suf[i] = ((num[i] - '0') * p + suf[i + 1]) % b;
		}

		long rem = (num[0] - '0') % a;
		int ans = -1;
		for (int i = 1; i < num.length; i++) {
			if (rem == 0 && num[i] != '0') {
				if (suf[i] == 0) {
					ans = i - 1;
					break;
				}
			}
			rem = (rem * 10 + (num[i] - '0')) % a;
		}
		StringBuffer answer = new StringBuffer();
		if (ans == -1)
			System.out.println("NO");
		else {
			answer.append("YES\n");
			for (int i = 0; i < num.length; i++) {
				if (i == ans + 1)
					answer.append("\n");
				answer.append(num[i]);
			}
			System.out.println(answer);
		}
	}
}
