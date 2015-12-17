import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div256B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] s = bf.readLine().toCharArray();
		char[] t = bf.readLine().toCharArray();
		int j = 0;
		int countS[] = new int[26];
		int countT[] = new int[26];
		for (int i = 0; j < t.length && i < s.length; i++) {
			if (s[i] == t[j]) {
				j++;
				if (j == t.length) {
					System.out.println("automaton");
					return;
				}
			}
		}
		for (int i = 0; i < s.length; i++) {
			countS[s[i] - 'a']++;
		}
		for (int i = 0; i < t.length; i++) {
			countT[t[i] - 'a']++;
		}
		boolean both = false;
		for (int i = 0; i < 26; i++) {
			if (countT[i] > countS[i]) {
				System.out.println("need tree");
				return;
			}
			if (countS[i] > countT[i]) {
				both = true;
			}
		}
		if (both) {
			System.out.println("both");
		} else {
			System.out.println("array");
		}
	}
}
