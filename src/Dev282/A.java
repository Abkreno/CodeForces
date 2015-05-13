package Dev282;

import java.util.Scanner;

public class A {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int arr[] = { 2, 7, 2, 3, 3, 4, 2, 5, 1, 2 };
		int first = Integer.parseInt(n.charAt(0) + "");
		int sec = Integer.parseInt(n.charAt(1) + "");
		System.out.println(arr[first] * arr[sec]);
	}
}
