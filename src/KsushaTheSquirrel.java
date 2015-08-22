import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class KsushaTheSquirrel {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		char[] road = sc.nextLine().toCharArray();
		int next[] = new int[n];
		Arrays.fill(next, -1);
		int prev = 0;
		for (int i = 1; i < next.length; i++) {
			if (i - prev > k) {
				prev = next[prev];
				if (prev == -1) {
					System.out.println("NO");
					return;
				}
			}
			if (road[i] == '.') {
				next[prev] = i;
			}

		}
		System.out.println("YES");
	}
}
