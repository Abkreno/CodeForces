import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lorry {
	public static class veh implements Comparable<veh> {
		int index, capacity, type;

		public veh(int i, int capacity, int t) {
			this.index = i;
			this.capacity = capacity;
			this.type = t;
		}

		@Override
		public int compareTo(veh v1) {
			if (v1.type == type)
				return v1.capacity - capacity;
			else
				return v1.type - type;
		}

		public String toString() {
			return this.type + " - " + this.capacity;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int v = Integer.parseInt(l[1]);
		veh[] boxes = new veh[n];
		int t2C = 0;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			int t = Integer.parseInt(l[0]);
			int c = Integer.parseInt(l[1]);
			boxes[i] = new veh(i, c, t);
			if (t == 2)
				t2C++;
		}
		int c = t2C;
		long best = Integer.MIN_VALUE;
		int counttwos = 0;
		Arrays.sort(boxes);
		while (c >= 0) {
			int weight = v;
			int i = 0;
			long max = 0;
			for (i = 0; i < c && weight > 1; i++, weight -= 2) {
				max += boxes[i].capacity;
			}
			for (i = t2C; i < n && weight > 0; i++, weight -= 1) {
				max += boxes[i].capacity;
			}
			if (max > best) {
				best = max;
				counttwos = c;
			}
			c--;
		}
		System.out.println(best);
		int weight = v;
		for (int i = 0; i < counttwos && weight > 1; i++, weight -= 2) {
			System.out.println(boxes[i].index + 1);

		}
		for (int i = t2C; i < boxes.length && weight > 0; i++, weight -= 1) {
			System.out.println(boxes[i].index + 1);
		}
	}

}
