package Div1_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GadgetsForDollarsAndPounds {
	static int n, m, k, s, dollars[], pounds[], x, y;
	static Num pricesD[], pricesP[];
	static int[] tmp1, tmp2;

	static class Num implements Comparable<Num> {
		int price, index;

		Num(int p, int c) {
			index = c + 1;
			price = p;
		}

		@Override
		public int compareTo(Num arg0) {
			return Integer.compare(price, arg0.price);
		}

		public String toString() {
			return price + "";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		k = Integer.parseInt(l[2]);
		s = Integer.parseInt(l[3]);
		if (m < k) {
			System.out.println(-1);
			return;
		}
		dollars = new int[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			dollars[i] = Integer.parseInt(l[i]);
		}

		pounds = new int[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			pounds[i] = Integer.parseInt(l[i]);
		}
		int t = 0;
		x = 0;
		y = 0;
		int both[][] = new int[2][m];
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			t = Integer.parseInt(l[0]) - 1;
			if (t == 0)
				x++;
			else
				y++;
			both[t][i] = Integer.parseInt(l[1]);
			both[1 - t][i] = -1;
		}
		int c;
		c = 0;
		pricesD = new Num[x];
		tmp1 = new int[x];
		for (int i = 0; i < m; i++) {
			if (both[0][i] != -1)
				pricesD[c++] = new Num(both[0][i], i);
		}
		Arrays.sort(pricesD);

		c = 0;
		pricesP = new Num[y];
		tmp2 = new int[y];
		for (int i = 0; i < m; i++) {
			if (both[1][i] != -1)
				pricesP[c++] = new Num(both[1][i], i);
		}
		Arrays.sort(pricesP);
		int mid, lo = 0;
		int hi = n;
		while (lo + 1 < hi) {
			mid = (lo + hi) >> 1;
			if (check(mid, s, k)) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		if (check(hi, s, k)) {
			System.out.println(hi);
			System.out.print(getAns(hi, s, k));
		} else {
			System.out.println(-1);
		}
	}

	private static String getAns(int days, int burles, int need) {
		StringBuffer ans = new StringBuffer();
		long minDollar = dollars[0];
		int dday = 1;
		for (int i = 1; i < days; i++) {
			if (dollars[i] < minDollar) {
				dday = i + 1;
				minDollar = dollars[i];
			}
		}
		long minPound = pounds[0];
		int pday = 1;
		for (int i = 1; i < days; i++) {
			if (pounds[i] < minPound) {
				pday = i + 1;
				minPound = pounds[i];
			}
		}
		int i = 0, j = 0;
		long priceD, priceP;
		while (need > 0) {
			priceD = i < x ? ((long) pricesD[i].price) * minDollar
					: Long.MAX_VALUE;
			priceP = j < y ? ((long) pricesP[j].price) * minPound
					: Long.MAX_VALUE;
			if (priceD < priceP) {
				ans.append(pricesD[i].index + " " + dday + "\n");
				i++;
			} else {
				ans.append(pricesP[j].index + " " + pday + "\n");
				j++;
			}
			need--;
		}
		return ans.toString();
	}

	private static boolean check(int days, int burles, int need) {
		long minDollar = dollars[0];
		for (int i = 1; i < days; i++) {
			minDollar = Math.min(minDollar, dollars[i]);
		}
		long minPound = pounds[0];
		for (int i = 1; i < days; i++) {
			minPound = Math.min(minPound, pounds[i]);
		}
		int i = 0, j = 0;
		long priceD, priceP;
		while (need > 0) {
			priceD = i < x ? ((long) pricesD[i].price) * minDollar
					: Long.MAX_VALUE;
			priceP = j < y ? ((long) pricesP[j].price) * minPound
					: Long.MAX_VALUE;
			if (priceD < priceP) {
				i++;
			} else {
				priceD = priceP;
				j++;
			}
			if (burles < priceD)
				return false;
			burles -= priceD;
			need--;
		}
		return need == 0;
	}
}
