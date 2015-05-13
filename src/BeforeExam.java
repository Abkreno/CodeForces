import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BeforeExam {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int d = Integer.parseInt(l[0]);
		int sum = Integer.parseInt(l[1]);
		int days[] = new int[d];
		int minMax[][] = new int[2][d];
		for (int i = 0; i < d; i++) {
			l = bf.readLine().split(" ");
			minMax[0][i] = Integer.parseInt(l[0]);
			minMax[1][i] = Integer.parseInt(l[1]);
		}
		for (int i = 0; i < d; i++) {
			days[i] = minMax[0][i];
			sum -= minMax[0][i];
		}
		if (sum < 0) {
			System.out.println("NO");
		} else {
			for (int i = 0; i < d && sum > 0; i++) {
				int left = minMax[1][i] - days[i];
				if (sum >= left) {
					sum -= left;
					days[i] += left;
				} else {
					days[i] += sum;
					sum = 0;
				}
			}
			if (sum != 0)
				System.out.println("NO");
			else {
				System.out.println("YES");
				for (int i = 0; i < days.length; i++) {
					System.out.print(days[i] + " ");
				}
			}
		}
	}
}
