package Div2_C;

import java.util.Scanner;

public class XeniaAndWeights {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] l = sc.nextLine().toCharArray();
		int m = sc.nextInt();

		StringBuffer bf = new StringBuffer("NO");
		outer: for (int k = 0; k < l.length; k++) {
			if (l[k] == '1') {
				int c1 = k + 1;
				int c2 = 0;
				int p1 = k + 1;
				boolean first = false;
				if (k + 1 == 2)
					first = false;
				bf = new StringBuffer("YES\n" + (c1) + " ");
				lop: for (int i = 1; i < m; i++) {
					for (int j = 0; j < l.length; j++) {
						if (l[j] == '1') {
							if (first && (c1 + j + 1) > c2 && j + 1 != p1) {
								c1 += j + 1;
								bf.append(j + 1 + " ");
								first = !first;
								p1 = j + 1;
								if (i + 1 == m)
									break outer;
								continue lop;
							} else if (!first && (c2 + j + 1) > c1
									&& j + 1 != p1) {
								c2 += j + 1;
								bf.append(j + 1 + " ");
								first = !first;
								p1 = j + 1;
								if (i + 1 == m)
									break outer;
								continue lop;
							}

						}
					}
					bf = new StringBuffer("NO");
					break lop;
				}
			}
		}
		System.out.println(bf);
	}
}