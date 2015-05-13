import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VasyaAndFouls {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String home = bf.readLine();
		String away = bf.readLine();
		boolean h[] = new boolean[99];
		boolean a[] = new boolean[99];
		boolean doneA[] = new boolean[99];
		boolean doneB[] = new boolean[99];

		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			String l[] = bf.readLine().split(" ");
			if (l[3].equals("r")
					|| (a[Integer.parseInt(l[2]) - 1] && l[1].equals("a"))
					|| (h[Integer.parseInt(l[2]) - 1] && l[1].equals("h"))) {
				if ((!doneA[Integer.parseInt(l[2]) - 1] && l[1].equals("a"))
						|| (!doneB[Integer.parseInt(l[2]) - 1] && l[1]
								.equals("h"))) {
					System.out.println((l[1].equals("h") ? home : away) + " "
							+ l[2] + " " + l[0]);
					if (l[1].equals("h"))
						doneB[Integer.parseInt(l[2]) - 1] = true;
					else
						doneA[Integer.parseInt(l[2]) - 1] = true;
				}
			} else {
				if (l[1].equals("h"))
					h[Integer.parseInt(l[2]) - 1] = true;
				else
					a[Integer.parseInt(l[2]) - 1] = true;
			}
		}
	}
}
