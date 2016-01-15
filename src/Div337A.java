import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div337A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(bf.readLine());
		if(n<4||n%2==1){
			System.out.println(0);
			return;
		}
		long res = (n / 4) - ((n % 4 == 0) ? 1 : 0);
		System.out.println(res);
	}
}
