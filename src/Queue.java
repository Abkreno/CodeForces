import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Queue {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l;
		int next[] = new int[1000001];
		int prev[] = new int[1000001];
		Arrays.fill(next, -1);
		Arrays.fill(prev, -1);

		HashSet<Integer> last = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			int a = Integer.parseInt(l[0]);
			int b = Integer.parseInt(l[1]);
			if (last.contains(b))
				last.remove(b);
			if (a != 0 && prev[a] == -1)
				last.add(a);
			next[a] = b;
			prev[b] = a;
		}
		int c = n - 1;
		Iterator<Integer> iter = last.iterator();
		int start = iter.next();
		System.out.print(start + " ");
		int curr = next[0];
		while (c != 0) {
			System.out.print(curr + " ");
			int temp = curr;
			curr = next[start];
			start = temp;
			c--;
		}
	}
}
