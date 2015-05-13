package Dev280;

import java.util.Scanner;

public class A {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int levels = 0;
		int k = 1;
		int c = 2;
		while (n > 0) {
			n -= k;
			if (n >= 0)
				levels++;
			k += c;
			c++;
		}
		System.out.println(levels);
	}
}
