import java.util.Scanner;

public class Squats {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		char[] x = sc.nextLine().toCharArray();
		int up = 0;
		int down = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == 'X')
				up++;
			else
				down++;
		}
		int left = 0;
		int ans = 0;
		if (up < down) {
			left = ans = down - n / 2;
			for (int i = 0; left > 0 && i < x.length; i++) {
				if (x[i] == 'x') {
					x[i] = 'X';
					left--;
				}
			}
		} else {
			left = ans = up - n / 2;
			for (int i = 0; left > 0 && i < x.length; i++) {
				if (x[i] == 'X') {
					x[i] = 'x';
					left--;
				}
			}
		}
		System.out.println(ans);
		System.out.println(String.valueOf(x));
	}
}
