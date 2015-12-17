import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Div331A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l;
		if (n == 1) {
			System.out.println(-1);
			return;
		} else if (n == 2) {
			l = bf.readLine().split(" ");
			int x1 = Integer.parseInt(l[0]);
			int y1 = Integer.parseInt(l[1]);
			l = bf.readLine().split(" ");
			int x2 = Integer.parseInt(l[0]);
			int y2 = Integer.parseInt(l[1]);
			int ans = checkValid(x1, x2, y1, y2);
			System.out.println(ans);
			return;
		}
		int[][] arr = new int[2][n];
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			arr[0][i] = Integer.parseInt(l[0]);
			arr[1][i] = Integer.parseInt(l[1]);
		}
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a = Math.max(a, Math.abs(arr[0][i] - arr[0][j]));
				b = Math.max(b, Math.abs(arr[1][i] - arr[1][j]));
			}
		}
		System.out.println(a * b);
	}

	private static int checkValid(int x1, int x2, int y1, int y2) {
		if (x1 == x2 || y2 == y1) {
			return -1;
		} else {
			int a = Math.abs(x1 - x2);
			int b = Math.abs(y1 - y2);
			return a * b;
		}
	}
}
