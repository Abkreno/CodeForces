import java.util.Scanner;

public class PoliceRecruits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int have = 0;
		int res = 0;
		int curr;
		for (int i = 0; i < n; i++) {
			curr = sc.nextInt();
			if (curr < 0) {
				have -= (-1*curr);
				if (have < 0) {
					res += (-1 * have);
					have = 0;
				}
			} else
				have += curr;
		}
		System.out.println(res);
	}
}
