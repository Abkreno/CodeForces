import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AmrAndLargeArray {
	static class N {
		int firstOccur, lastOccur;
		int count;

		N() {
			firstOccur = lastOccur = -1;
			count = 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int nums[] = new int[n];
		N[] c = new N[1000001];
		for (int i = 0; i < c.length; i++) {
			c[i] = new N();
		}
		int maxCount = -1;
		int bestL = 0;
		int bestR = 1000001;
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
			if (c[nums[i]].firstOccur == -1)
				c[nums[i]].firstOccur = c[nums[i]].lastOccur = i;
			else
				c[nums[i]].lastOccur = i;
			c[nums[i]].count++;
			int k = nums[i];
			if (c[k].count > maxCount
					|| (c[k].count == maxCount && c[k].lastOccur
							- c[k].firstOccur < bestR - bestL)) {
				maxCount = c[k].count;
				bestL = c[k].firstOccur;
				bestR = c[k].lastOccur;
			}
		}

		System.out.println((bestL + 1) + " " + (bestR + 1));
	}
}
