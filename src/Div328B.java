import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div328B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(bf.readLine());
		long ans = (n - 1) * (n - 2) - (n - 2);
		System.out.println(ans);
	}
}
