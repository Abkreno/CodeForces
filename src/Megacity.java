import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Megacity {
	static class City implements Comparable<City> {
		int pop;
		double dist;

		City(int p, double d) {
			pop = p;
			dist = d;
		}

		@Override
		public int compareTo(City o) {
			if (dist < o.dist)
				return -1;
			if (dist > o.dist)
				return 1;
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int s = 1000000 - Integer.parseInt(l[1]);
		City[] cities = new City[n];
		double d;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			d = Point.distance(Integer.parseInt(l[0]), Integer.parseInt(l[1]),
					0, 0);
			cities[i] = new City(Integer.parseInt(l[2]), d);
		}
		Arrays.sort(cities);
		for (int i = 0; i < cities.length; i++) {
			s -= cities[i].pop;
			if (s <= 0) {
				System.out.println(cities[i].dist);
				return;
			}
		}
		System.out.println(-1);
	}
}
