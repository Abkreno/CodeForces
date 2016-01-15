package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Div339C {
	static class N implements Comparable<N> {
		long val;
		int index;

		N(int val, int i) {
			this.val = val;
			index = i;
		}

		@Override
		public int compareTo(N o) {
			return Long.compare(val, o.val);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		long N = n;
		long A = Integer.parseInt(l[1]);
		long cf = Integer.parseInt(l[2]);
		long cm = Integer.parseInt(l[3]);
		long m = Long.parseLong(l[4]);
		N[] nums = new N[n + 1];
		l = bf.readLine().split(" ");
		nums[0] = new N(0, 0);
		for (int i = 1; i < nums.length; i++) {
			nums[i] = new N(Integer.parseInt(l[i - 1]), i);
		}
		Arrays.sort(nums);
		long needToA[] = new long[n + 2];
		for (int i = n; i >= 0; i--) {
			needToA[i] += A - nums[i].val;
			needToA[i] += needToA[i + 1];
		}
		long sums[] = new long[n + 1];
		for (int i = 1; i < sums.length; i++) {
			sums[i] = sums[i - 1] + nums[i].val;
		}
		long lo, hi, mid;
		int lo2, hi2, mid2, ind;
		int bestInd = 0;
		int bestInd2 = n + 1;
		long bestMin = 0;
		long best = 0;
		long left;
		long c;
		long costNeeded;
		for (int i = n + 1; i > 0; i--) {
			if (needToA[i] > m)
				break;
			left = m - needToA[i];
			lo = ind = 0;
			hi = A;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				lo2 = 0;
				hi2 = i;
				while (lo2 + 1 < hi2) {
					mid2 = (lo2 + hi2) >> 1;
					if (nums[mid2].val <= mid) {
						lo2 = mid2;
					} else {
						hi2 = mid2;
					}
				}
				costNeeded = lo2 * mid - sums[lo2];
				if (left >= costNeeded) {
					lo = mid;
					ind = lo2;
				} else {
					hi = mid;
				}
			}
			costNeeded = ind * lo - sums[ind];
			if (left >= costNeeded) {
				c = (n - i + 1) * cf;
				if (i == 1)
					c += A * cm;
				else
					c += lo * cm;
				if (c > best) {
					best = c;
					bestMin = lo;
					bestInd = ind;
					bestInd2 = i;
				}
			}
		}
		for (int i = bestInd; i > 0; i--) {
			nums[i].val = bestMin;
		}
		for (int i = bestInd2; i < nums.length; i++) {
			nums[i].val = A;
		}
		long ans[] = new long[n + 1];
		for (int i = 1; i < ans.length; i++) {
			ans[nums[i].index] = nums[i].val;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < ans.length; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(best);
		System.out.println(sb);
	}
}
