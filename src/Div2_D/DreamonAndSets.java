package Div2_D;

import java.util.Scanner;

public class DreamonAndSets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int multiple = 2;
		boolean used[] = new boolean[3000001];
		int a, b, c, tmp;
		int max = k;
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < n; i++, multiple++) {
			a = 1;
			b = 1 * multiple;
			c = 0;
			while (true) {
				if (!used[a]) {
					used[a] = true;
					max = Math.max(max, a*k);
					ans.append(a*k);
					c++;
					if (c == 4) {
						ans.append("\n");
						break;
					} else {
						ans.append(" ");
					}
				}
				if (!used[b]) {
					used[b] = true;
					max = Math.max(max, b*k);
					ans.append(b*k);
					c++;
					if (c == 4) {
						ans.append("\n");
						break;
					} else {
						ans.append(" ");
					}
				}
				tmp = a;
				a = b;
				b += tmp;
			}
		}
		System.out.println(max);
		System.out.print(ans);
	}
}
