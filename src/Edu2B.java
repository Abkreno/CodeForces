import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Edu2B {
	static int nums1[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		nums1 = new int[n];
		for (int i = 0; i < l.length; i++) {
			nums1[i] = Integer.parseInt(l[i]);
		}
		l = bf.readLine().split(" ");
		Arrays.sort(nums1);
		StringBuffer ans = new StringBuffer();
		int nums2[] = new int[m];
		for (int i = 0; i < l.length; i++) {
			nums2[i] = Integer.parseInt(l[i]);
			int c = count(nums2[i]);
			if (nums1[c] <= nums2[i])
				c = c + 1;
			else
				c = 0;
			ans.append(c + " ");
		}
		System.out.println(ans);
	}

	private static int count(int i) {
		int lo = 0, mid;
		int hi = nums1.length;
		while (lo + 1 < hi) {
			mid = (lo + hi) >> 1;
			if (nums1[mid] > i) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		return lo;
	}
}
