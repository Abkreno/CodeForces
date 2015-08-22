package A2_Div2_C;

import java.util.Scanner;

public class DNAAlignment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		sc.nextLine();
		char[] s = sc.nextLine().toCharArray();
		int counts[] = new int[26];
		for (int i = 0; i < s.length; i++) {
			counts[s[i] - 'A']++;
		}
		int max = 0;
		for (int i = 0; i < counts.length; i++) {
			max = Math.max(counts[i], max);
		}
		long characters = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == max)
				characters++;
		}
		long ans = 1;
		long mod = 1000000007;
		for (int i = 0; i < len; i++) {
			ans *= characters;
			ans %= mod;
		}
		System.out.println(ans);
	}
}
