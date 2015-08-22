import java.io.IOException;
import java.util.Scanner;

public class Div315A {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long t = sc.nextInt();
		long s = sc.nextInt();
		long q = sc.nextInt();
		long ans = 1;
		long currSec = 0;
		while (s < t) {
			s += q - 1;
			currSec += q;
			if (currSec<t&&currSec >= s) {
				currSec = 0;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
