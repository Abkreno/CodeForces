package Div2_C;

import java.util.Scanner;

public class LittleFrog {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuffer str = new StringBuffer();
		str.append(1 + " ");
		boolean plus = true;
		int curr = 1;
		for (int i = n - 1; i > 0; i--) {
			if (plus) {
				str.append(curr + i + " ");
				curr = curr + i;
			} else {
				str.append(curr - i + " ");
				curr = curr - i;
			}
			plus = !plus;
		}
		System.out.println(str);
	}
}
