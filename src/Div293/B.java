package Div293;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		char[] t = sc.nextLine().toCharArray();
		int yay = 0;
		int whoops = 0;
		HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length; i++) {
			if (mapT.containsKey(t[i]))
				mapT.put(t[i], mapT.get(t[i]) + 1);
			else
				mapT.put(t[i], 1);
		}
		boolean[] done = new boolean[s.length];
		for (int i = 0; i < s.length; i++) {
			if (mapT.containsKey(s[i])) {
				yay++;
				done[i] = true;
				int val = mapT.get(s[i]);
				if (val == 1)
					mapT.remove(s[i]);
				else
					mapT.put(s[i], val - 1);
			}
		}
		for (int i = 0; i < s.length; i++) {
			if (done[i])
				continue;
			char cD = (s[i] + "").toLowerCase().charAt(0);
			char cU = (s[i] + "").toUpperCase().charAt(0);
			if (cD == s[i]) {
				if (mapT.containsKey(cU)) {
					int val = mapT.get(cU);
					if (val == 1)
						mapT.remove(cU);
					else
						mapT.put(cU, val - 1);
					whoops++;
				}
			} else {
				if (mapT.containsKey(cD)) {
					int val = mapT.get(cD);
					if (val == 1)
						mapT.remove(cD);
					else
						mapT.put(cD, val - 1);
					whoops++;
				}
			}
		}
		System.out.println(yay + " " + whoops);
	}
}
