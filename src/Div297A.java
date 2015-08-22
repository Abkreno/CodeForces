import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Div297A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] have = new int[26];
		Arrays.fill(have, 0);
		char line[] = bf.readLine().toCharArray();
		int ans = 0;
		for (int i = 0; i < line.length; i += 2) {
			char f = line[i];
			char s = (line[i + 1] + "").toLowerCase().charAt(0);
			if (f == s)
				continue;
			if (have[s - 'a'] > 0) {
				have[f - 'a']++;
				have[s - 'a']--;
				continue;
			}
			have[f - 'a']++;
			ans++;
		}
		System.out.println(ans);
	}
}
