package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SoldierAndNumberGame {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		String[] l;
		countFactors();
		int[] round = new int[5000010];
		for (int i = 2; i < round.length; i++) {
			round[i] = round[i - 1] + factors[i];
		}
		int a, b, ans;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]);
			b = Integer.parseInt(l[1]);
			ans = round[a] - round[b];
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}

	static int factors[] = new int[5000020];

	public static void countFactors() {
		long N = 5000010;
		boolean[] isPrime = new boolean[(int) N + 1];
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;

		}

		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				factors[i] = 1;
				for (long j = 2; i * j <= N; j++) {
					isPrime[(int) (i * j)] = false;
					factors[(int) (i * j)] = 1 + factors[(int) j];
				}
			}
		}

	}

}
