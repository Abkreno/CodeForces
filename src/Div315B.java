import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Div315B {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String line[] = bf.readLine().split(" ");
		int counts[] = new int[100000 + 1];
		int nums[] = new int[n];
		int curr;
		for (int i = 0; i < line.length; i++) {
			curr = Integer.parseInt(line[i]);
			counts[curr]++;
			nums[i] = curr;
		}
		LinkedList<Integer> notSeen = new LinkedList<>();
		for (int i = 1; i < n + 1; i++) {
			if (counts[i] == 0)
				notSeen.add(i);
		}
		boolean[] seen = new boolean[n + 1];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= n && !seen[nums[i]]) {
				seen[nums[i]] = true;
			} else if (nums[i] > n || seen[nums[i]]) {
				nums[i] = notSeen.remove();
				seen[nums[i]] = true;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}
