import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class DimaAndConyLine {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int nums[] = new int[n];
		int connect[] = new int[n];
		LinkedList<Integer> covered[] = new LinkedList[n];

		String l[] = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
			connect[i] = nums[i];
		}
		Arrays.sort(nums);
		int id = 1;
		boolean flag = false;
		for (int i = 0; i < n - 1; i++) {
			int from = Arrays.binarySearch(nums, connect[i]);
			int to = Arrays.binarySearch(nums, connect[i + 1]);
			if (covered[from] == null)
				covered[from] = new LinkedList<Integer>();
			if (covered[to] == null)
				covered[to] = new LinkedList<Integer>();
			covered[from].add(id);
			covered[to].add(id++);
			if (from > to) {
				int temp = from;
				from = to;
				to = temp;
			}
			HashSet<Integer> soFar = new HashSet<Integer>();
			for (int j = from + 1; j < to; j++) {
				if (covered[j] != null) {
					for (int x : covered[j]) {
						if (soFar.contains(x)) {
							soFar.remove(x);
						} else if (!covered[from].contains(x)
								&& !covered[to].contains(x)) {
							soFar.add(x);
						}
					}
				}
			}
			if (soFar.size() > 0) {
				flag = true;
				break;
			}
		}
		System.out.println(flag ? "yes" : "no");
	}
}
