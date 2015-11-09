import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Div249A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		int curr;
		int ans = 1;
		int currBus = m;
		for (int i = 0; i < l.length; i++) {
			curr = Integer.parseInt(l[i]);
			if (currBus < curr) {
				currBus = 0;
				curr -= currBus;
				ans++;
				currBus = m - curr;
			} else {
				currBus -= curr;
			}
		}
		System.out.println(ans);
	}
}
