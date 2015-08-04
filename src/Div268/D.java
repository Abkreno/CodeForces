package Div268;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {
	static class Num implements Comparable<Num> {
		int val, index, i, j, pAt, pAtM;
		boolean taken;

		Num(int v, int i) {
			val = v;
			index = i;
			taken = false;
			this.i = -1;
			this.j = -1;
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

	static Num[] nums;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		int a = Integer.parseInt(l[1]);
		int b = Integer.parseInt(l[2]);
		l = bf.readLine().split(" ");
		nums = new Num[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new Num(Integer.parseInt(l[i]), i);
		}
		Arrays.sort(nums);
		int need;
		for (int i = 0; i < n; i++) {
			need = a - nums[i].val;
			modify(need, i, true);
			need = b - nums[i].val;
			modify(need, i, false);
		}
		boolean takenByB[] = new boolean[n];
		int taken = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i].pAt == 1) {
				int indx = nums[i].i == -1 ? nums[i].j : nums[i].i;
				if (nums[indx].taken) {
					break;
				}
				nums[indx].taken = true;
				nums[indx].pAtM--;
				if (nums[i].val + nums[indx].val == b) {
					takenByB[nums[i].index] = takenByB[nums[indx].index] = true;
				}
				taken += 2;
			} else if (nums[i].pAt == 2) {
				int indx1 = nums[i].i;
				int indx2 = nums[i].j;
				boolean good = true;
				if (!nums[indx1].taken && nums[indx1].pAt <= nums[indx2].pAt
						&& nums[indx1].pAtM <= nums[indx2].pAtM) {
					nums[indx1].taken = true;
					nums[indx1].pAtM--;
					if (nums[i].val + nums[indx1].val == b) {
						takenByB[nums[i].index] = takenByB[nums[indx1].index] = true;
					}
					taken += 2;
				} else {
					good = false;
				}
				if (!good) {
					if (nums[indx2].taken)
						break;
					nums[indx2].taken = true;
					nums[indx2].pAtM--;
					if (nums[i].val + nums[indx2].val == b) {
						takenByB[nums[i].index] = takenByB[nums[indx2].index] = true;
					}
					taken += 2;
				}
			}
		}
		if (taken == n) {
			System.out.println("YES");
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < n; i++) {
				if (takenByB[i])
					str.append(1 + " ");
				else
					str.append(0 + " ");
			}
			System.out.println(str);
		} else {
			System.out.println("NO");
		}

	}

	static void modify(int need, int i, boolean f) {
		if (need >= 0 && need > nums[i].val) {
			int indx = Arrays.binarySearch(nums, new Num(need, 0));
			if (indx >= 0 && indx < n) {
				nums[indx].pAtM++;
				nums[i].pAt++;
				if (f)
					nums[i].i = indx;
				else
					nums[i].j = indx;
			}
		}
	}
}
