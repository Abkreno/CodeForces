import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DivFFB {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] s = bf.readLine().toCharArray();
		int k = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int c[] = new int[26];
		int max = 0;
		for (int i = 0; i < c.length; i++) {
			c[i] = Integer.parseInt(l[i]);
			max = Math.max(max, c[i]);
		}
		long ans = 0;
		for (int i = 1; i <= s.length; i++) {
			ans += ((long) (c[s[i - 1] - 'a'] * i));
		}
		for (long i = s.length + 1; i <= s.length + k; i++) {
			ans += ((long) (i * max));
		}
		System.out.println(ans);
	}
}
