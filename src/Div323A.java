import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Div323A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(bf.readLine());
		int a, b;
		String[] l;
		boolean madeH[] = new boolean[50 * 50 + 5];
		boolean madeV[] = new boolean[50 * 50 + 5];
		for (int i = 0; i < n * n; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]);
			b = Integer.parseInt(l[1]);
			if (!madeH[a] && !madeV[b]) {
				madeH[a] = madeV[b] = true;
				System.out.print((i + 1) + " ");
			}
		}
		System.out.println();
	}
}
