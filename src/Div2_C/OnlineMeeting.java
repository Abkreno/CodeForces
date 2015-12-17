package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class OnlineMeeting {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		if (n == 1) {
			System.out.println(1 + "\n" + 1);
			return;
		}
		int m = Integer.parseInt(l[1]);
		boolean isLeader[] = new boolean[n + 1];
		boolean done[] = new boolean[n + 1];
		int here[] = new int[n + 1];
		Arrays.fill(isLeader, true);
		Arrays.fill(here, 2);
		char t;
		int curr, prev = 0, count = 0, left = 0;
		LinkedList<Integer> hereAndL = new LinkedList<>();
		LinkedList<Integer> leftAndL = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			t = l[0].charAt(0);
			curr = Integer.parseInt(l[1]);
			if (t == '+') {
				here[curr] = 1;
				if (count > 0) {
					isLeader[curr] = false;
					done[curr] = true;
				} else if (prev == curr && count == 0 && !done[curr]) {
					isLeader[curr] = true;
					left--;
				} else if (left > 0) {
					isLeader[curr] = false;
					done[curr] = true;
				}
				while (!leftAndL.isEmpty()) {
					int tmp = leftAndL.remove();
					if (here[tmp] == 0) {
						isLeader[tmp] = false;
						done[tmp] = true;
					}
				}

				if (isLeader[curr]) {
					hereAndL.add(curr);
				}

				count++;

			} else {
				left++;
				if (here[curr] == 1)
					count--;
				else if (here[curr] == 2) {
					while (!hereAndL.isEmpty()) {
						int tmp = hereAndL.remove();
						isLeader[tmp] = false;
						done[tmp] = true;
					}
					hereAndL.add(curr);
				}
				here[curr] = 0;
				if (count > 0)
					isLeader[curr] = false;
				if (isLeader[curr]) {
					leftAndL.add(curr);
				}
			}
	
			prev = curr;
		}
		StringBuilder ans = new StringBuilder();
		int res = 0;
		for (int i = 1; i < isLeader.length; i++) {
			if (isLeader[i]) {
				res++;
				ans.append(i + " ");
			}
		}
		System.out.println(res + "\n" + ans);
	}
}
