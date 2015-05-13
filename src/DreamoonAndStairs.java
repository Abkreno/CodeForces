import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DreamoonAndStairs {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		int ans = -1;
		for (int i = m; i <= n; i += m) {
			if (i * 2 >= n){
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}
