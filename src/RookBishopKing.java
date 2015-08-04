import java.util.Scanner;

public class RookBishopKing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		int rock = (Math.abs(r2 - r1) > 0 ? 1 : 0)
				+ (Math.abs(c1 - c2) > 0 ? 1 : 0);
		int bishop = 0;
		int king = Math.max(Math.abs(r2 - r1), Math.abs(c2 - c1));
		if ((r1 + c1) % 2 == (r2 + c2) % 2) {
			bishop = Math.abs(r2 - r1) == Math.abs(c2 - c1) ? 1 : 2;
		}
		System.out.println(rock + " " + bishop + " " + king);
	}
}
