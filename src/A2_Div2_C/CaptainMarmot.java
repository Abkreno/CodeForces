package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CaptainMarmot {
	static boolean isSquare(int[][] co) {
		long[] ds = new long[6];
		int p = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				ds[p++] = (long) (co[i][0] - co[j][0]) * (co[i][0] - co[j][0])
						+ (long) (co[i][1] - co[j][1]) * (co[i][1] - co[j][1]);
			}
		}
		Arrays.sort(ds);
		return ds[0] > 0 && ds[3] == ds[0] && ds[4] == ds[3] * 2
				&& ds[4] == ds[5];
	}

	static void rotate(int[] c) {
		int x = c[0], y = c[1];
		int a = c[2], b = c[3];
		int nx = -(y - b) + a;
		int ny = (x - a) + b;
		c[0] = nx;
		c[1] = ny;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		String[] l;
		for (int T = n; T >= 1; T--) {
			int[][] co = new int[4][];
			for (int i = 0; i < 4; i++) {
				co[i] = new int[4];
				l = bf.readLine().split(" ");
				for (int j = 0; j < 4; j++) {
					co[i][j] = Integer.parseInt(l[j]);
				}
			}
			int min = 999;
			for (int a = 0; a < 4; a++) {
				for (int b = 0; b < 4; b++) {
					for (int c = 0; c < 4; c++) {
						for (int d = 0; d < 4; d++) {
							if (isSquare(co)) {
								min = Math.min(min, a + b + c + d);
							}
							rotate(co[3]);
						}
						rotate(co[2]);
					}
					rotate(co[1]);
				}
				rotate(co[0]);
			}
			System.out.println(min == 999 ? -1 : min);
		}
	}
}
