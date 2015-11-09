import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoderStrike_A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int a = Integer.parseInt(l[1]);
		int b = Integer.parseInt(l[2]);
		boolean pasha[] = new boolean[n + 1];
		boolean arthur[] = new boolean[n + 1];
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			arthur[Integer.parseInt(l[i])] = true;
		}
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			pasha[Integer.parseInt(l[i])] = true;
		}
		for (int i = 1; i <= n; i++) {
			if (arthur[i]) {
				System.out.print(1 + " ");
			} else {
				System.out.print(2 + " ");
			}
		}
		System.out.println();
	}
}
