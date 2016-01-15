import java.util.Scanner;

public class nums {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char[] q = sc.nextLine().toCharArray();
		int sande[][] = new int[2][n];
		int count = 1;
		if (n == 1) {
			System.out.println("YES");
			for (int i = 0; i < q.length; i++) {
				System.out.print(q[i]);
			}
			System.out.println();
			return;
		}
		boolean occured[] = new boolean[26];
		occured[q[0] - 'a'] = true;
		StringBuffer ans = new StringBuffer();
		for (int i = 1; i < q.length; i++) {
			if (!occured[q[i] - 'a']) {
				occured[q[i] - 'a'] = true;
				sande[0][count] = i;
				sande[1][count - 1] = i - 1;
				count++;
				if (count == n) {
					sande[1][count - 1] = q.length - 1;
					ans.append("YES\n");
					for (int j = 0; j < n; j++) {
						for (int k = sande[0][j]; k <= sande[1][j]; k++) {
							ans.append(q[k]);
						}
						ans.append("\n");
					}
					System.out.print(ans);
					return;
				}
			}
		}
		System.out.println("NO");
	}

	static double eps = 1e-9;

	static int compare(double a, double b) {
		if (Math.abs(a - b) < eps)
			return 0;
		if (a - b < 0.0)
			return -1;
		return 1;
	}
}
