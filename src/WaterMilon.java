import java.util.Scanner;

public class WaterMilon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		boolean good = false;
		for (int i = 2; i < w; i++) {
			if (i % 2 == 0 && (w - i) % 2 == 0) {
				good = true;
				break;
			}
		}
		System.out.println(good ? "YES" : "NO");
	}
}
