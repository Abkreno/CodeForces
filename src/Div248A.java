import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Div248A {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[] = bf.readLine().split(" ");
		int x = 0;
		int y = 0;
		for (int i = 0; i < l.length; i++) {
			int curr = Integer.parseInt(l[i]);
			if (curr == 100) {
				x++;
			} else {
				y++;
			}
		}
		while (y > 0) {
			y--;
			if (y > 0)
				y--;
			else if (x > 1) {
				x -= 2;
			} else {
				System.out.println("NO");
				return;
			}
		}
		while (x > 0) {
			x--;
			if (x == 0) {
				System.out.println("NO");
				return;
			}
			x--;
		}
		System.out.println("YES");
	}
}