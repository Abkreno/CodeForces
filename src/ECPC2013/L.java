package ECPC2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;

public class L {
	static LinkedList<Integer> index[] = new LinkedList[26];
	static int L, S;
	static boolean exists[][] = new boolean[26][26];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader("mahdi.in"));
		int t = Integer.parseInt(bf.readLine());
		String[] l;
		int i, s, currInd, temp, cases = 1;
		int len, adder, mult, n;
		for (i = 0; i < 26; i++) {
			index[i] = new LinkedList<>();
		}
		StringBuilder ans = new StringBuilder();
		while (t-- > 0) {

			l = bf.readLine().split(" ");
			s = l[0].charAt(0) - 'a';
			L = Integer.parseInt(l[1]);
			S = 0;
			mult = Integer.parseInt(l[2]);
			adder = Integer.parseInt(l[3]);
			fillSeq(L, adder, mult, s);
			n = Integer.parseInt(bf.readLine());
			ans.append("Case " + cases + ":\n");
			cases++;
			loop: while (n-- > 0) {
				l = bf.readLine().split(" ");
				s = l[0].charAt(0) - 'a';
				len = Integer.parseInt(l[1]);
				mult = Integer.parseInt(l[2]);
				adder = Integer.parseInt(l[3]);
				i = 0;
				currInd = 0;
				while (i++ < len) {
					temp = lowerBound(currInd, s);
					if (temp < currInd) {
						ans.append("REPEAT\n");
						continue loop;
					}
					currInd = temp;
					s = (s * mult + (i) * adder) % 26;
				}
				ans.append("BRAVO\n");
			}
			for (i = 0; i < 26; i++) {
				Arrays.fill(exists[i], false);
				index[i].clear();
			}
		}
		System.out.print(ans);
	}

	static int lowerBound(int currInd, int s) {
		int best = Integer.MAX_VALUE;
		int j;
		for (int i : index[s]) {
			j = (currInd / S) * S + i;
			if (j < currInd)
				j += S;
			if (j >= currInd && j < L)
				best = Math.min(best, j);
		}
		if (best == Integer.MAX_VALUE)
			best = -1;
		return best;
	}

	static void fillSeq(int len, int adder, int mult, int s) {
		int i = 0;
		while (i++ < len) {
			if (exists[(s * mult) % 26][(i * adder) % 26]) {
				break;
			}
			S++;
			index[s].add(i - 1);
			exists[(s * mult) % 26][(i * adder) % 26] = true;
			s = (s * mult + (i) * adder) % 26;
		}
	}
}
