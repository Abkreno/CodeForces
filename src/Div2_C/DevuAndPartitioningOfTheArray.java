package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class DevuAndPartitioningOfTheArray {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		int p = Integer.parseInt(l[2]);
		LinkedList<Integer> evens[] = new LinkedList[p];
		for (int i = 0; i < evens.length; i++) {
			evens[i] = new LinkedList<>();
		}
		LinkedList<Integer> odds[] = new LinkedList[k - p];
		for (int i = 0; i < odds.length; i++) {
			odds[i] = new LinkedList<>();
		}
		l = bf.readLine().split(" ");
		if (p == 0) {
			if (!fillOdds(odds, n, k, p, l)) {
				System.out.println("NO");
				return;
			}
		} else if (k - p == 0) {
			if (!fillEvens(evens, n, k, p, l)) {
				System.out.println("NO");
				return;
			}
		} else {
			int curr, indE = 0, indO = 0;
			LinkedList<Integer> leftOdds = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				curr = Integer.parseInt(l[i]);
				if (curr % 2 == 0) {
					if (indE == p)
						indE--;
					evens[indE].add(curr);
					if (indE < p)
						indE++;
				} else if (indO < k - p) {
					odds[indO].add(curr);
					indO++;
				} else {
					leftOdds.add(curr);
				}
			}
			if (indO != k - p) {
				System.out.println("NO");
				return;
			}
			if (indE < p) {
				int left = p - indE;
				if (leftOdds.size() / 2 < left) {
					System.out.println("NO");
					return;
				}
				for (int i = indE; i < p; i++) {
					evens[i].add(leftOdds.remove());
					evens[i].add(leftOdds.remove());
				}
			}
			if (leftOdds.size() % 2 == 1) {
				System.out.println("NO");
				return;
			}
			while (!leftOdds.isEmpty())
				evens[0].add(leftOdds.remove());
		}

		// Print
		StringBuffer ans = new StringBuffer();
		ans.append("YES\n");
		for (int i = 0; i < p; i++) {
			ans.append(evens[i].size() + " ");
			for (int c : evens[i])
				ans.append(c + " ");
			ans.append("\n");
		}
		for (int i = 0; i < k - p; i++) {
			ans.append(odds[i].size() + " ");
			for (int c : odds[i])
				ans.append(c + " ");
			ans.append("\n");
		}
		System.out.print(ans);
	}

	private static boolean fillEvens(LinkedList<Integer>[] evens, int n, int k,
			int p, String[] l) {
		int curr, indE = 0;
		LinkedList<Integer> odds = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			curr = Integer.parseInt(l[i]);
			if (curr % 2 == 0) {
				if (indE == p)
					indE--;
				evens[indE].add(curr);
				if (indE < p)
					indE++;
			} else {
				odds.add(curr);
			}
		}
		if (odds.size() % 2 == 1) {
			return false;
		}
		if (indE < p) {
			int left = p - indE;
			if (odds.size() / 2 < left) {
				return false;
			}
			for (int i = indE; i < p; i++) {
				evens[i].add(odds.remove());
				evens[i].add(odds.remove());
			}
		}
		while (!odds.isEmpty())
			evens[p - 1].add(odds.remove());
		return true;
	}

	private static boolean fillOdds(LinkedList<Integer>[] odds, int n, int k,
			int p, String[] l) {
		int curr, indO = 0;
		LinkedList<Integer> evens = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			curr = Integer.parseInt(l[i]);
			if (curr % 2 == 0) {
				evens.add(curr);
			} else {
				odds[indO].add(curr);
				if (indO + 1 != k - p)
					indO++;
			}
		}
		if (odds[k - p - 1].size() % 2 == 0) {
			return false;
		}
		while (!evens.isEmpty())
			odds[0].add(evens.remove());
		return true;
	}
}
