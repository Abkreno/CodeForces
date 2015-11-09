package Div325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int p[] = new int[n];
		int v[] = new int[n];
		long d[] = new long[n];
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			v[i] = Integer.parseInt(l[0]);
			d[i] = Integer.parseInt(l[1]);
			p[i] = Integer.parseInt(l[2]);
		}
		boolean neg;
		long x, z;
		int first, f2;
		long dec[] = new long[n];
		long dec2[] = new long[n];
		StringBuilder ans = new StringBuilder();
		int c = 0;
		for (int i = 0; i < d.length; i++) {
			if (p[i] < 0)
				continue;
			else {
				ans.append(i + 1 + " ");
				c++;
				neg = false;
				z = v[i];
				first = n;
				for (int j = i + 1; j < n && z > 0; j++) {
					if (p[j] < 0)
						continue;
					p[j] -= z;
					if (p[j] < 0 && j + 1 < n) {
						dec[j + 1] = d[j];
						first = Math.min(first, j + 1);
						neg = true;
					}
					z--;
				}
				while (neg) {
					neg = false;
					f2 = n;
					x = 0;
					for (int j = first; j < n; j++) {
						x += dec[j];
						if (p[j] < 0)
							continue;
						p[j] -= x;
						if (p[j] < 0 && j + 1 < n) {
							f2 = Math.min(f2, j + 1);
							dec2[j + 1] = d[j];
							neg = true;
						}
					}
					for (int j = 0; j < dec2.length; j++) {
						dec[j] = dec2[j];
						dec2[j] = 0;
					}
					first = f2;
				}
				Arrays.fill(dec, 0);
				Arrays.fill(dec2, 0);
			}
		}
		System.out.println(c + "\n" + ans);
	}
}
