import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Div258A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		boolean flag = true;
		while (n * m != 0) {
			n--;
			m--;
			flag = !flag;
		}
		System.out.println(flag ? "Malvika" : "Akshat");
	}
}
