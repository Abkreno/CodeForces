import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MemSqlRound1A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		char[] word = bf.readLine().toCharArray();
		String[] names = new String[] { "vaporeon", "jolteon", "flareon",
				"espeon", "umbreon", "leafeon", "glaceon", "sylveon" };
		loop: for (int i = 0; i < names.length; i++) {
			if (names[i].length() == word.length) {
				for (int j = 0; j < word.length; j++) {
					if (word[j] != '.' && names[i].charAt(j) != word[j])
						continue loop;
				}
				System.out.println(names[i]);
				break;
			}
		}
	}
}
