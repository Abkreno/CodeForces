package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PashmakAndBuses {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		int d = Integer.parseInt(l[2]);

		int arr[][] = new int[n][d];
		Arrays.fill(arr[0], 1);
		boolean flag = true;
		loop: for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1].clone();
			for (int j = 0; j < d; j++) {
				if (arr[i][j] < k) {
					arr[i][j]++;
					continue loop;
				} else {
					arr[i][j] = 1;
				}
			}
			flag = false;
			break;
		}
		if (flag) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(arr[j][i] + " ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		} else {
			System.out.println(-1);
		}
	}
}
