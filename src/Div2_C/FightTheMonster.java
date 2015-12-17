package Div2_C;

import java.util.Scanner;

public class FightTheMonster {
	static int Hy, Ay, Dy, Hm, Am, Dm;
	static int h, a, d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hy = sc.nextInt();
		Ay = sc.nextInt();
		Dy = sc.nextInt();
		Hm = sc.nextInt();
		Am = sc.nextInt();
		Dm = sc.nextInt();
		h = sc.nextInt();
		a = sc.nextInt();
		d = sc.nextInt();
		int l = -1;
		int h = 1000000;
		while (l + 1 < h) {
			int mid = (l + h) / 2;
			if (check(mid)) {
				h = mid;
			} else {
				l = mid;
			}
		}
		System.out.println(h);
	}

	static boolean check(int mid) {
		for (int atk = 0; atk <= 1000; atk++) {
			for (int def = 0; def <= 1000 - atk; def++) {
				if (atk + Ay <= Dm)
					continue;
				int hp = HP(atk + Ay, def + Dy) - Hy;
				if (hp < 0)
					hp = 0;
				int price = atk * a + def * d + hp * h;
				if (price < 0) {
					System.out.println(atk + " " + def + " " + hp);
				}
				if (price <= mid)
					return true;
			}

		}
		return false;
	}

	static int HP(int atk, int def) {
		int numOfRounds = Hm / (atk - Dm);
		if (Hm % (atk - Dm) > 0)
			numOfRounds++;
		return (Am - def) * numOfRounds + 1;
	}
}
