import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

public class SortingON {

	static int[] sort(int[] a) {
		int n = a.length, sum = 0, avg, pos = 0;
		int[] b = new int[n];
		Stack<Integer> G = new Stack<Integer>(), L = new Stack<Integer>(), E = new Stack<Integer>(), Backup = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		avg = sum / n;
		for (int i = 0; i < n; i++) {
			if (a[i] > avg) {
				if (G.isEmpty() || G.peek() >= a[i]) {
					G.push(a[i]);
				} else {
					while (!G.isEmpty() && G.peek() < a[i])
						Backup.push(G.pop());
					G.push(a[i]);
					while (!Backup.isEmpty())
						G.push(Backup.pop());
				}
			} else if (a[i] < avg) {
				if (L.isEmpty() || L.peek() >= a[i]) {
					L.push(a[i]);
				} else {
					while (!L.isEmpty() && L.peek() < a[i])
						Backup.push(L.pop());
					L.push(a[i]);
					while (!Backup.isEmpty())
						L.push(Backup.pop());
				}
			} else {
				E.push(a[i]);
			}
		}
		while (!L.isEmpty())
			b[pos++] = ((Integer) L.pop()).intValue();
		while (!E.isEmpty())
			b[pos++] = ((Integer) E.pop()).intValue();
		while (!G.isEmpty())
			b[pos++] = ((Integer) G.pop()).intValue();

		return b;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			a[i] = r.nextInt(10);
		}
		System.out.println(Arrays.toString(sort(a)));
	}

}
