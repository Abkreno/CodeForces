import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div246A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		int c = 0;
		for (int i = 0; i < l.length; i++) {
			int curr = Integer.parseInt(l[i]);
			if (5 - curr >= k)
				c++;
		}
		System.out.println(c / 3);
	}
}
