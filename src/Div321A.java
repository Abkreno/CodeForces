import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div321A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int prev = 0, curr, max = 1, count = 0;
		for (int i = 0; i < l.length; i++) {
			curr = Integer.parseInt(l[i]);
			if (curr >= prev) {
				count++;
				max = Math.max(max, count);
			} else {
				count = 1;
				max = Math.max(max, count);
			}
			prev = curr;
		}
		System.out.println(max);

	}
}
