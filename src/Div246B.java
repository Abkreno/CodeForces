import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div246B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[];
		int[][] ah = new int[2][n];
		int[] countH = new int[100001];
		int[] countA = new int[100001];
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			ah[0][i] = Integer.parseInt(l[0]);
			ah[1][i] = Integer.parseInt(l[1]);
			countH[ah[0][i]]++;
			countA[ah[1][i]]++;
		}
		StringBuffer ans = new StringBuffer();
		int total ,home;
		for (int i = 0; i < n; i++) {
			total = 2 * (n - 1);
			home = n - 1;
			home += countH[ah[1][i]];
			total -= home;
			ans.append(home + " " + total + "\n");
		}
		System.out.print(ans);
	}
}
