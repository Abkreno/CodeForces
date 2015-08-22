import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Div287A {

	static class p implements Comparable<p> {
		int i, m;

		p(int x, int a) {
			i = x;
			m = a;
		}

		@Override
		public int compareTo(p o) {
			if (m > o.m)
				return 1;
			if (m < o.m)
				return -1;
			return 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		p[] nums = new p[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new p(i + 1, Integer.parseInt(l[i]));
		}
		Arrays.sort(nums);
		int res = 0;
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i].m > m) {
				break;
			} else {
				res++;
				m -= nums[i].m;
				ans.append(nums[i].i + " ");
			}
		}
		System.out.println(res);
		if (res != 0)
			System.out.println(ans);
	}
}
