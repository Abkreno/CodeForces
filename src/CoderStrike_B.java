import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoderStrike_B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] l = bf.readLine().toCharArray();
		String abc = "AHIMOTUVWXY"; // check Q
		for (int i = 0, j = l.length - 1; i < j; i++, j--) {
			if (l[i] != l[j]) {
				System.out.println("NO");
				return;
			}
		}
		for (int i = 0; i < l.length; i++) {
			if (!abc.contains(l[i] + "")) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
