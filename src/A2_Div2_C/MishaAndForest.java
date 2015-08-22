package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MishaAndForest {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int degree[] = new int[n];
		int xor[] = new int[n];
		String[] l;
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			degree[i] = Integer.parseInt(l[0]);
			if (degree[i] == 1)
				q.add(i);
			xor[i] = Integer.parseInt(l[1]);
		}
		int curr, next,a=0;
		StringBuffer ans = new StringBuffer();
		while (!q.isEmpty()) {
			curr = q.pop();
			if (degree[curr] == 0)
				continue;
			next = xor[curr];
			ans.append(curr + " " + next + "\n");
			a++;
			xor[next] ^= curr;
			degree[next]--;
			if (degree[next] == 1)
				q.add(next);
		}
		System.out.print(a+"\n"+ans);

	}
}
