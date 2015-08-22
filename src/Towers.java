import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Towers {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		int[] towers = new int[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < towers.length; i++) {
			towers[i] = Integer.parseInt(l[i]);

		}
		if (n == 1) {
			System.out.println(0 + " " + 0);
			return;
		}
		StringBuffer ans = new StringBuffer();
		int c = 0;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, maxInd, minInd;
		for (int i = 0; i < k; i++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			minInd = 1;
			maxInd = 1;
			for (int j = 0; j < towers.length; j++) {
				if (towers[j] > max) {
					max = towers[j];
					maxInd = j + 1;
				}
				if (towers[j] < min) {
					min = towers[j];
					minInd = j + 1;
				}
			}
			if (max == min)
				break;
			towers[maxInd - 1]--;
			towers[minInd - 1]++;
			ans.append(maxInd + " " + minInd + "\n");
			c++;
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < towers.length; i++) {
			max = Math.max(max, towers[i]);
			min = Math.min(min, towers[i]);
		}
		System.out.println(max - min + " " + c);
		System.out.print(ans);
	}

}
