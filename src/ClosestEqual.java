import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class ClosestEqual {
	static int n, m, maxsize;

	static class P {
		int dist, next_equal, index, next_index;

		P(int dist, int next, int i) {
			this.dist = dist;
			this.next_equal = next;
			this.index = i;
		}

		public String toString() {
			return "(" + index + ") next>> " + next_equal + " -->" + next_index;
		}
	}

	public static void main(String[] args) throws Exception {
		HashMap<Integer, Integer> lookUpTable = new HashMap<Integer, Integer>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");

		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		P[] arr = new P[n];
		l = bf.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			int curr = Integer.parseInt(l[i]);
			if (lookUpTable.containsKey(curr)) {
				int prev = lookUpTable.get(curr);
				arr[prev] = new P(i - prev, i, prev);
			}
			lookUpTable.put(curr, i);
		}
		P prev = null;
		int lastGood = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] != null) {
				prev = arr[i];
				lastGood = i;
				break;
			}
			arr[i] = new P(Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
		}

		for (int i = lastGood; i >= 0; i--) {
			if (arr[i] != null) {
				arr[i].next_index = prev.index;
				prev = arr[i];
			} else {
				arr[i] = new P(Integer.MAX_VALUE, 0, prev.index);
			}
		}
		if (lastGood != -1)
			arr[lastGood].next_index = Integer.MAX_VALUE;
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			int beg = Integer.parseInt(l[0]) - 1;
			int end = Integer.parseInt(l[1]) - 1;
			P curr = arr[beg];
			if(curr.dist==Integer.MAX_VALUE&&curr.index<n)curr=arr[curr.index];
			int minDist = Integer.MAX_VALUE;
			while (curr.index <= end && curr.index <= lastGood) {
				if (curr.next_equal <= end) {
					minDist = Math.min(minDist, curr.dist);
				}
				if (curr.next_index >= n )
					break;
				curr = arr[curr.next_index];
			}
			minDist = minDist == Integer.MAX_VALUE ? -1 : minDist;
			b.append(minDist + "\n");
		}
		System.out.println(b);
	}

}
