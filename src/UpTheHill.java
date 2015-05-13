import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UpTheHill {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(bf.readLine());
		int b = Integer.parseInt(bf.readLine());
		int nums[] = new int[a + b + 1];
		for (int i = 0; i <= a; i++) {
			System.out.print(i + 1 + b + " ");
		}
		for (int i = b; i > 0; i--) {
			System.out.print(i + " ");
		}

	}
}
