import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LalaLandAndAppleTree {
	static class Num implements Comparable<Num> {
		int newInd;
		int pos, val;

		Num(int v, int i) {
			pos = v;
			val = i;
		}

		@Override
		public int compareTo(Num o) {
			if (pos > o.pos)
				return 1;
			if (pos < o.pos)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l;
		Num nums[] = new Num[n];
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			nums[i] = new Num(Integer.parseInt(l[0]), Integer.parseInt(l[1]));
		}
		Arrays.sort(nums);
		int sR = n;
		int sL = n - 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i].pos > 0) {
				sR = i;
				sL = i - 1;
				break;
			}
		}
		long res1 = 0;
		// start right
		for (int i = sR, j = sL; i < nums.length && j > -2; i++, j--) {
			res1 += nums[i].val;
			if (j >= 0)
				res1 += nums[j].val;
			else
				break;
		}
		long res2 = 0;
		// start left
		for (int i = sR, j = sL; i < nums.length + 2 && j >= 0; i++, j--) {
			res2 += nums[j].val;
			if (i < n)
				res2 += nums[i].val;
			else
				break;
		}
		System.out.println(Math.max(res1, res2));
	}
}
