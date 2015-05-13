package A2_Div2_C;

import java.util.Arrays;
import java.util.Scanner;

public class TableDecorations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long[] a = new long[] { in.nextInt(), in.nextInt(), in.nextInt() };
		Arrays.sort(a);
		System.out.println(Math.min((a[0] + a[1] + a[2]) / 3, a[0] + a[1]));
	}
}
