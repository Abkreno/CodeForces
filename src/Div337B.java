import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div337B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		if (n < 2) {
			if (n == 1) {
				System.out.println("*+\n++");
				return;
			}
			if (n == 0) {
				System.out.println("*");
				return;
			}
		}
		solve(n);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static char[][] arr;

	static void solve(int n) {
		arr = new char[1 << n][1 << n];
		init(arr);
		for (int currPow = 2; currPow < n; currPow++) {
			int k, shift;
			shift = (1 << currPow) - 1;
			for (int i = 0; i < (1 << currPow); i++) {
				k = 0;
				for (int j = (1 << currPow); j < (1 << (currPow + 1)); j++, k++) {
					arr[i][j] = arr[i][k];
				}
				k = 0;
				for (int j = (1 << currPow); j < (1 << (currPow + 1)); j++) {
					for (int x = 0; x <= shift; x++) {
						arr[j][x] = arr[k][x];
					}
					for (int x = shift + 1; x < (1 << (currPow + 1)); x++) {
						arr[j][x] = arr[k][x] == '*' ? '+' : '*';
					}
					k++;
				}
			}
		}
	}

	static boolean checkRowsEqual(int i, int j) {
		for (int j2 = 0; j2 < arr.length; j2++) {
			if (arr[i][j2] != arr[j][j2])
				return false;
		}
		return true;
	}

	private static void init(char[][] arr) {
		int i = 0;
		arr[i][0] = '+';
		arr[i][1] = '+';
		arr[i][2] = '*';
		arr[i][3] = '*';
		i++;
		arr[i][0] = '+';
		arr[i][1] = '*';
		arr[i][2] = '+';
		arr[i][3] = '*';
		i++;
		arr[i][0] = '+';
		arr[i][1] = '+';
		arr[i][2] = '+';
		arr[i][3] = '+';
		i++;
		arr[i][0] = '+';
		arr[i][1] = '*';
		arr[i][2] = '*';
		arr[i][3] = '+';

	}
}
