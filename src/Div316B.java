import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Div316B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n == 1) {
			System.out.println(1);
			return;
		}
		int dif1 = n - m;
		int dif2 = m - 1;
		if (dif1 > dif2 || m == 1) {
			System.out.println(m + 1);
		} else {
			System.out.println(m - 1);
		}
	}
}
