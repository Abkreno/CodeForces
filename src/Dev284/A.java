package Dev284;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		HashMap<String, String> dic = new HashMap<String, String>();
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			String w1 = l[0];
			String w2 = l[1];
			if (w2.length() < w1.length()) {
				dic.put(w1, w2);
				dic.put(w2, w2);
			} else {
				dic.put(w2, w1);
				dic.put(w1, w1);
			}
		}
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			System.out.print(dic.get(l[i]) + " ");
		}

	}
}
