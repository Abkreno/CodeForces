import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AandBandSubstrings {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int[] vals = new int[26];
		for (int i = 0; i < l.length; i++) {
			vals[i] = Integer.parseInt(l[i]);
		}
		char[] s = bf.readLine().toCharArray();
		int[] w = new int[s.length];
		for (int i = 0; i < w.length; i++) {
			w[i] = vals[s[i] - 'a'];
		}
		
	}
}
