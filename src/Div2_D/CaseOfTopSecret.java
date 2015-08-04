package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CaseOfTopSecret {
	static Num[] nums;
	static int INF = 1000000001;

	static class Num implements Comparable<Num> {
		int newInd;
		long val, ind;

		Num(long v, int i) {
			val = v;
			ind = i;
		}

		@Override
		public int compareTo(Num o) {
			if (val > o.val)
				return 1;
			if (val < o.val)
				return -1;
			return 0;
		}
	}

	static boolean f;
	static long len;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		nums = new Num[n];
		Num[] ind = new Num[n];
		for (int i = 0; i < n; i++) {
			nums[i] = new Num(Integer.parseInt(l[i]), i);
			ind[i] = nums[i];
		}
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			nums[i].newInd = i;
		}
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			int pos = ind[Integer.parseInt(l[0]) - 1].newInd;
			len = Integer.parseInt(l[1]);
			f = false;
			while (true) {
				int newPos = get(pos);
				if (f) {
					break;
				}
				if (newPos == pos) {
				}
				pos = newPos;
			}
			ans.append(nums[pos].ind + 1 + "\n");
		}
		System.out.print(ans);
	}

	static int get(int pos) {
		int c = 0;
		int newPos = higherBound(pos, len);
		int tmp = newPos;
		if (newPos == pos)
			c++;
		len = (len - Math.abs(nums[newPos].val - nums[pos].val));
		newPos = lowerBound(newPos, len);
		if (newPos == pos)
			c++;
		if (c == 2)
			f = true;
		if (!f && newPos == pos) {
			boolean flag = (len / Math.abs(nums[newPos].val - nums[tmp].val) % 2 == 0);
			len = len % Math.abs(nums[newPos].val - nums[tmp].val);
			if (flag)
				newPos = tmp;
		} else
			len = len - Math.abs(nums[newPos].val - nums[tmp].val);

		return newPos;
	}

	static int higherBound(int pos, long len) {
		int lo = pos;
		int hi = nums.length;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (len - Math.abs(nums[mid].val - nums[pos].val) >= 0) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	static int lowerBound(int pos, long len) {
		int lo = -1;
		int hi = pos;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (len - Math.abs(nums[mid].val - nums[pos].val) >= 0) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		return hi;
	}
}
