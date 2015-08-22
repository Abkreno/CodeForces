import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BrandNewEasyProblem {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] problem = bf.readLine().split(" ");
		int m = Integer.parseInt(bf.readLine());
		String[][] problems = new String[m][];
		for (int i = 0; i < m; i++) {
			problems[i] = bf.readLine().split(" ");
		}
		int inversions[] = new int[m];
		int indeces[] = new int[n];
		for (int i = 0; i < m; i++) {
			indeces = new int[n];
			for (int j = 0; j < n; j++) {
				for (int k = 1; k < problems[i].length; k++) {
					if (equal(problems[i][k], problem[j])) {
						indeces[j] = k;
					}
				}
			}
		}
	}

	private static boolean equal(String string, String string2) {
		if (string.length() != string2.length())
			return false;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != string2.charAt(i))
				return false;
		}
		return true;
	}
}
