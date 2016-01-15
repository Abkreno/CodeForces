package Div2_D;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class SpongebobAndSquares {
	static class Num implements Comparable<Num> {
		long n, m;

		Num(long x, long m2) {
			n = x;
			m = m2;
		}

		@Override
		public int compareTo(Num arg0) {
			return Long.compare(n, arg0.n);
		}

		public String toString() {
			return n + " " + m;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		sc.close();
		int maxM = 10000000;
		long n, m;
		long s, ss, tmp1, tmp2;
		StringBuffer ans = new StringBuffer();
		LinkedList<Num> stack = new LinkedList<>();
		for (m = 1; m <= maxM; m++) {
			s = sumN(m);
			ss = sumN2(m);
			tmp1 = x + s * (m + 1) - ss;
			tmp2 = (m + 1) * m - s;
			if (tmp1 % tmp2 == 0) {
				n = (tmp1 / tmp2) - 1;
				if (n < m)
					continue;
				stack.push(new Num(m, n));
				if (n != m)
					stack.push(new Num(n, m));
			}
		}
		Collections.sort(stack);
		Num curr;
		long prev = -1;
		int res = 0;
		HashSet<Long> used = new HashSet<>();
		while (!stack.isEmpty()) {
			curr = stack.pop();
			if (curr.n == prev) {
				if (used.contains(curr.m))
					continue;
				else
					used.add(curr.m);
			} else {
				prev = curr.n;
				used.clear();
				used.add(curr.m);
			}
			ans.append(curr + "\n");
			res++;
		}
		System.out.print(res + "\n" + ans);
	}

	private static long sumN(long n) {
		return (n * (n + 1)) / 2;
	}

	private static long sumN2(long n) {
		return (n * (n + 1) * (2 * n + 1)) / 6;
	}
}
