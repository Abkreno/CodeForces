package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoodSubStrings {
	static char[] good, word;
	static int res, K, n;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		word = bf.readLine().toCharArray();
		good = bf.readLine().toCharArray();
		K = Integer.parseInt(bf.readLine());
		n = word.length;
		node myNode = new node();
		for (int i = 0; i < n; i++) {
			myNode.insert(i, 0);
		}
		System.out.println(res);
	}

	static class node {
		node[] myNodes = new node[26];

		void insert(int i, int j) {
			if (i == word.length || j > K)
				return;
			char curr = word[i];
			int k = 1 - (good[curr - 'a'] - '0');
			if (myNodes[curr - 'a'] == null) {
				if (j + k <= K)
					res++;
				myNodes[curr - 'a'] = new node();
			}
			myNodes[curr - 'a'].insert(i + 1, j + k);
		}
	}
}
