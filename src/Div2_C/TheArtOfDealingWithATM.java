package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TheArtOfDealingWithATM {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		int nums[] = new int[n];
		HashMap<Integer, Integer> valMoves = new HashMap<>();
		valMoves.put(0, 0);
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
			for (int j = 1; j <= k; j++) {
				if (valMoves.containsKey(nums[i] * j)) {
					valMoves.put(nums[i] * j,
							Math.min(j, valMoves.get(nums[i] * j)));
				} else {
					valMoves.put(nums[i] * j, j);
				}
			}
		}
		int curr, q = Integer.parseInt(bf.readLine());
		int minMoves, currMoves, left;
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < q; i++) {
			curr = Integer.parseInt(bf.readLine());
			minMoves = Integer.MAX_VALUE;
			for (int key : valMoves.keySet()) {
				if (key > curr || !valMoves.containsKey(curr - key))
					continue;
				minMoves = Math.min(minMoves,
						valMoves.get(key) + valMoves.get(curr - key));
			}
			if (minMoves > k)
				minMoves = -1;
			ans.append(minMoves + "\n");
		}
		System.out.print(ans);
	}
}
