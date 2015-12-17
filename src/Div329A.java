import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Div329A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		char[][] arr = new char[n][];
		int totalLen = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = bf.readLine().toCharArray();
			totalLen += arr[i].length;
		}
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if (i == j)
					continue;
				int currRem = 0;
				for (int k = 0; k < n; k++) {
					for (int x = 0; x < arr[k].length; x++) {
						if (arr[k][x] - 'a' != i && arr[k][x] - 'a' != j) {
							currRem += arr[k].length;
							break;
						}
					}
				}
				max = Math.max(max, totalLen - currRem);
			}
		}
		System.out.println(max);
	}
}
