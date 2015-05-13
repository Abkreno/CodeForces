import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestPathOfTheKing {
	static String row = "abcdefgh";
	static int pX, pY, dX, dY, cX, cY, ansX, ansY, c;

	static void shortestPath(int x, int y) {
		if (x > 7 || y > 7)
			return;
		if (x == dX) {
			ansY = dY - y;
			return;
		}
		if (y == dY) {
			ansX = dX - x;
			return;
		}
		c++;
		shortestPath(x + cX, y + cY);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] pos = bf.readLine().toCharArray();
		char[] dest = bf.readLine().toCharArray();
		pX = row.indexOf(pos[0]);
		pY = pos[1] - '0' - 1;
		dX = row.indexOf(dest[0]);
		dY = dest[1] - '0' - 1;
		c = 0;
		ansX = 0;
		ansY = 0;
		if (dY > pY) {
			cY = 1;
		} else {
			cY = -1;
		}
		if (dX > pX) {
			cX = 1;
		} else {
			cX = -1;
		}
		shortestPath(pX, pY);
		String diag = "";
		if (cY > 0) {
			if (cX > 0) {
				diag = "RU";
			} else {
				diag = "LU";
			}
		} else {
			if (cX > 0) {
				diag = "RD";
			} else {
				diag = "LD";
			}
		}
		boolean negative = false;

		if (ansX < 0) {
			ansX *= -1;
			negative = true;
		}
		if (ansY < 0) {
			ansY *= -1;
			negative = true;
		}
		System.out.println(ansY + ansX + c);
		for (int i = 0; i < c; i++) {
			System.out.println(diag);
		}
		for (int i = 0; i < ansY; i++) {
			System.out.println(negative ? 'D' : 'U');
		}
		for (int i = 0; i < ansX; i++) {
			System.out.println(negative ? 'L' : 'R');
		}
	}
}
