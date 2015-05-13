package Div271;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	static class Point2 {
		Point p, home;

		Point2(int x, int y, int x1, int y1) {
			p = new Point(x, y);
			home = new Point(x1, y1);
		}

		public void rotate() {
			this.p.x = home.x + home.y - p.y;
			this.p.y = -home.x + home.y + p.x;
			return;
		}

		public String toString() {
			return p.toString() + "  " + home.toString();
		}
	}

	static Point2[] Regminets;

	static boolean checkSquare() {
		double AB = Math.abs(Regminets[0].p.distance(Regminets[1].p));
		double AD = Math.abs(Regminets[0].p.distance(Regminets[2].p));
		double AC = Math.abs(Regminets[0].p.distance(Regminets[3].p));
		int cX = Regminets[0].p.x + Regminets[1].p.x + Regminets[2].p.x
				+ Regminets[3].p.x;
		int cY = Regminets[0].p.y + Regminets[1].p.y + Regminets[2].p.y
				+ Regminets[3].p.y;
		Point center = new Point(cX, cY);
		double CDis = Math.abs((Regminets[0].p.distance(center)) * 2.0);
		if (AB == AD) {
			double BD = Math.abs(Regminets[1].p.distance(Regminets[2].p));
			return BD == CDis && BD == AC;
		} else if (AD == AC) {
			double DC = Math.abs(Regminets[2].p.distance(Regminets[3].p));
			return DC == CDis && DC == AB;

		} else {
			double BC = Math.abs(Regminets[3].p.distance(Regminets[1].p));
			return BC == CDis && BC == AD;
		}
	}

	static int INF = 1000000;

	static int minMoves(int curr) {
		if (curr >= 4)
			return checkSquare() ? 0 : INF;
		int min = minMoves(curr + 1);
		int count = 4;
		Point2 temp = new Point2(Regminets[curr].p.x, Regminets[curr].p.y,
				Regminets[curr].home.y, Regminets[curr].home.y);
		while (count-- > 0) {
			Regminets[curr].rotate();
			min = Math.min(min, 1 + minMoves(curr + 1));
		}
		Regminets[curr] = temp;
		return min;
	}

	public static void main(String[] args) throws IOException {
		input.init(System.in);
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			Regminets = new Point2[4];
			for (int j = 0; j < 4; j++) {
				Regminets[j] = new Point2(input.nextInt(), input.nextInt(),
						input.nextInt(), input.nextInt());
			}
			int c = 0;
			int MIN = INF;
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					for (int m = 0; m < 4; m++) {
						for (int l = 0; l < 4; l++) {
							if (checkSquare())
								MIN = Math.min(c, MIN);
							Regminets[3].rotate();
							c++;
						}
						Regminets[2].rotate();
						c++;
					}
					Regminets[1].rotate();
					c++;
				}
				Regminets[0].rotate();
				c++;
			}
			if (MIN >= INF)
				MIN = -1;
			System.out.println(MIN);
		}
	}

	public static class input {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		/** call this method to initialize reader for InputStream */
		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}

		/** get next word */
		static String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				// TODO add check for eof if necessary
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		static long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}

}
