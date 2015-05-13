import java.util.HashMap;
import java.util.Scanner;

public class ErrorCorrectSys {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char[] S = sc.nextLine().toCharArray();
		char[] T = sc.nextLine().toCharArray();
		HashMap<Character, Integer>[] s = new HashMap[26];
		int res = 0;
		for (int i = 0; i < T.length; i++) {
			if (T[i] != S[i]) {
				if (s[S[i] - 'a'] == null)
					s[S[i] - 'a'] = new HashMap<Character, Integer>();
				s[S[i] - 'a'].put(T[i], i);
				res++;
			}
		}
		int bestI = -1;
		int bestJ = -1;
		int bestScore = 0;
		for (int i = 0; i < S.length; i++) {
			if (T[i] != S[i]) {
				if (s[T[i] - 'a'] != null) {
					if (s[T[i] - 'a'].containsKey(S[i])) {
						bestI = i + 1;
						bestJ = s[T[i] - 'a'].get(S[i]) + 1;
						bestScore = 2;
						break;
					} else {
						bestI = i + 1;
						bestJ = Integer.parseInt((s[T[i] - 'a'].entrySet()
								.toArray()[0]).toString().split("=")[1]) + 1;
						bestScore = 1;
					}
				}
			}
		}
		System.out.println(res - bestScore);
		System.out.println(bestI + " " + bestJ);
	}
}
