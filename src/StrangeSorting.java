import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrangeSorting {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char st[] = bf.readLine().toCharArray();
		char temp[] = new char[st.length];
		int q = Integer.parseInt(bf.readLine());
		while (q-- > 0) {
			String l[] = bf.readLine().split(" ");
			int k = Integer.parseInt(l[0]);
			int d = Integer.parseInt(l[1]);
			for (int i = 0; i + k <= temp.length; i++) {
				int c = i;
				for (int s = i; s < d + i; s++) {
					for (int j = s; j < k + i; j += d) {
						temp[c++] = st[j];
					}
				}
				for (int j = i; j < k + i; j++) {
					st[j] = temp[j];
				}
			}
			for (int i = 0; i < st.length; i++) {
				System.out.print(st[i]);
			}
			System.out.println();
		}
	}
}
