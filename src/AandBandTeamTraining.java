import java.util.Scanner;

public class AandBandTeamTraining {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int res = 0;
		if (m > n) {
			int temp = m;
			m = n;
			n = temp;
		}
		while (m > 0 && n > 1) {
			res++;
			m -= 1;
			n -= 2;
			if (m > n) {
				int temp = m;
				m = n;
				n = temp;
			}
		}
		System.out.println(res);
		sc.close();
	}
}
