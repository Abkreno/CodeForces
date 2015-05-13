package Div271;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String three = "qwertyuiopasdfghjkl;zxcvbnm,./";
		String s = sc.next();
		String word = sc.next();
		if (s.equals("R")) {
			for (int i = 0; i < word.length(); i++) {
				System.out
						.print(three.charAt(three.indexOf(word.charAt(i)) - 1));
			}
		} else {
			for (int i = 0; i < word.length(); i++) {
				System.out
						.print(three.charAt(three.indexOf(word.charAt(i)) + 1));
			}
		}
		System.out.println();
	}
}
