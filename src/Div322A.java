import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Div322A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//String[] l = bf.readLine().split(" ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a > b) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		System.out.println(a + " " + ((b - a) / 2));
	}
}
