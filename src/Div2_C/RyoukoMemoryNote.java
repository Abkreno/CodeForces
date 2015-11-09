package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class RyoukoMemoryNote {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		int nums[] = new int[m];
		for (int i = 0; i < m; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		LinkedList<Integer> count[] = new LinkedList[n + 1];
		for (int i = 1; i < count.length; i++) {
			count[i] = new LinkedList<Integer>();
		}
		long diff = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0) {
				diff += Math.abs(nums[i] - nums[i - 1]);
				if (nums[i] != nums[i - 1]) {
					count[nums[i]].add(nums[i - 1]);
				}
			}
			if (i < m - 1) {
				if (nums[i] != nums[i + 1]) {
					count[nums[i]].add(nums[i + 1]);
				}
			}
		}
		int best;
		long currDiff, bestDiff = diff;
		for (int i = 1; i < count.length; i++) {
			if (count[i].size() == 0)
				continue;
			Collections.sort(count[i]);
			best = count[i].get(count[i].size() / 2);
			currDiff = diff;
			for (int j : count[i]) {
				currDiff += Math.abs(j - best);
				currDiff -= Math.abs(i - j);
			}
			bestDiff = Math.min(bestDiff, currDiff);
			if (count[i].size() % 2 == 0) {
				best = count[i].get(count[i].size() / 2 - 1);
				currDiff = diff;
				for (int j : count[i]) {
					currDiff += Math.abs(j - best);
					currDiff -= Math.abs(i - j);
				}
				bestDiff = Math.min(bestDiff, currDiff);
			}
		}
		System.out.println(bestDiff);
	}
}