import java.util.Arrays;
import java.util.Scanner;

public class Div259A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] d = new char[n][n];
		for (int i = 0; i < d.length; i++) {
			Arrays.fill(d[i], '*');
		}
		int start = n / 2;
		int k = 1;
		for (int i = 0; k <= n; i++) {
			for (int j = start; j < start + k; j++) {
				d[i][j] = 'D';
			}
			start--;
			k += 2;
		}
		start = n / 2;
		k = 1;
		for (int i = n - 1; k <= n; i--) {
			for (int j = start; j < start + k; j++) {
				d[i][j] = 'D';
			}
			start--;
			k += 2;
		}
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				System.out.print(d[i][j] + "");
			}
			System.out.println();
		}

	}
}
