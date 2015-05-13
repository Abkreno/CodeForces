package Dev293;
import java.util.Scanner;

public class D {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double p = in.nextDouble();
		int t = in.nextInt();

		double[][] DP = new double[t + 2][n + 2];
		DP[0][0] = 1;

		for (int i = 0; i < t + 1; i++)
			for (int j = 0; j < n + 1; j++)
				if (j == n)
					DP[i + 1][j] += DP[i][j];
				else {
					DP[i + 1][j + 1] += DP[i][j] * p;
					DP[i + 1][j] += DP[i][j] * (1 - p);
				}
		double expectedVal = 0;
		for (int i = 0; i <= n; i++)
			expectedVal += DP[t][i] * i;
		System.out.println(expectedVal);
		in.close();
	}
}
