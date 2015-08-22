import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ModularEquations {
	static int a, b;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		a = Integer.parseInt(l[0]);
		b = Integer.parseInt(l[1]);
		if (a < b) {
			System.out.println(0);
		} else if (a == b) {
			System.out.println("infinity");
		} else {
			long res = 0;
			int diff = a - b;
			for (int i = 1; i * i <= diff; i++) {
				if (diff % i == 0 && i > b)
					res++;
				if (diff % i == 0 && i * i != diff && diff / i > b)
					res++;
			}
			System.out.println(res);
		}
	}
}