import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RCC_B {
	static int counts[] = new int[100005];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l;
		int a, b;

		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]);
			b = Integer.parseInt(l[1]);
			if (counts[b - 1] == a) {
				counts[b - 1]++;
			} else if (counts[b - 1] < a) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}
}
