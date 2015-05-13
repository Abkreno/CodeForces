import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Winner {

	static class trace {
		int score;
		String name;

		trace(int s, String n) {
			score = s;
			name = n;
		}

		public String toString() {
			return this.name + " " + this.score;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		HashMap<String, Integer> set = new HashMap<String, Integer>();
		trace[] t = new trace[n];
		for (int i = 0; i < n; i++) {
			String curr[] = bf.readLine().split(" ");
			int val = Integer.parseInt(curr[1]);
			int v2 = set.get(curr[0]) == null ? 0 : set.get(curr[0]);
			t[i] = new trace(val + v2, curr[0]);
			set.put(curr[0], val + v2);

		}

		int maxScore = Collections.max(set.values());

		for (int j = 0; j < t.length; j++) {
			if (t[j].score >= maxScore && set.get(t[j].name) >= maxScore) {
				System.out.println(t[j].name);
				break;
			}
		}

	}
}
