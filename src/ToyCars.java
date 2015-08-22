import java.util.Scanner;

public class ToyCars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int car[][] = new int[n][n];
		String l[];
		boolean bad[] = new boolean[n];
		int ans = n;
		for (int i = 0; i < car.length; i++) {
			l = sc.nextLine().split(" ");
			for (int j = 0; j < l.length; j++) {
				int curr = Integer.parseInt(l[j]);
				if (curr == -1)
					continue;
				if (curr % 2 == 1) {
					bad[i] = true;
					ans--;
					break;
				}
			}
		}
		System.out.println(ans);
		for (int i = 0; i < bad.length; i++) {
			if (!bad[i])
				System.out.print(i + 1 + " ");
		}
		System.out.println();
	}
}
