package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class ClosestEquals {
	static int nums[];
	static int segTree[] = new int[25 * 100000];
	static int INF = Integer.MAX_VALUE;
	static Q[] q;

	static class Q implements Comparable<Q> {
		int indx, l, r;

		Q(int i, int a, int b) {
			indx = i;
			l = a;
			r = b;
		}

		@Override
		public int compareTo(Q q) {
			if (r > q.r)
				return 1;
			if (r < q.r)
				return -1;
			return 0;
		}

	}

	static void update(int node, int l, int r, int i, int val) {
		if (l == r) {
			segTree[node] = Math.min(val, segTree[node]);
			return;
		}
		int mid = (l + r) >> 1;
		if (mid >= i) {
			update(node * 2 + 1, l, mid, i, val);
		} else {
			update(node * 2 + 2, mid + 1, r, i, val);
		}
		segTree[node] = Math.min(segTree[node * 2 + 1], segTree[node * 2 + 2]);
	}

	static int query(int node, int l, int r, int i, int j) {
		if (l > j || r < i)
			return INF;
		if (l == i && j == r) {
			return segTree[node];
		}
		int mid = (l + r) >> 1;
		return Math.min(query(node * 2 + 1, l, mid, i, Math.min(j, mid)),
				query(node * 2 + 2, mid + 1, r, Math.max(mid + 1, i), j));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		Arrays.fill(segTree, INF);
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]) + 1000000000;
		}
		q = new Q[m];
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			int a = Integer.parseInt(l[0]) - 1;
			int b = Integer.parseInt(l[1]) - 1;
			q[i] = new Q(i, a, b);
		}
		Arrays.sort(q);
		HashMap<Integer, Integer> lastIndex = new HashMap<>();
		int ans[] = new int[m];
		int j = 0;
		for (int i = 0; i < n && j < m; i++) {
			int index = lastIndex.containsKey(nums[i]) ? lastIndex.get(nums[i])
					: -1;
			lastIndex.put(nums[i], i);
			if (index != -1) {
				update(0, 0, n - 1, index, i - index);
			}
			while (j < m && q[j].r == i) {
				ans[q[j].indx] = query(0, 0, n - 1, q[j].l, i);
				j++;
			}
		}
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == INF)
				System.out.println(-1);
			else
				System.out.println(ans[i]);
		}
	}
}
