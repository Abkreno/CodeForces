import java.io.IOException;
import java.util.Scanner;

public class Div319A {
	

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int res = 0;
		for (int i = 1; i <= n; i++) {
			if (x % i == 0 && x / i <= n)
				res++;
		}
		System.out.println(res);
	}
}
