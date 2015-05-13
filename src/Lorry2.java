import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lorry2 {
	public static class veh2 implements Comparable<veh2> {
		int index, type;
		long capacity;

		public veh2(int i, long capacity, int t) {
			this.index = i;
			this.capacity = capacity;
			this.type = t;
		}

		@Override
		public int compareTo(veh2 v1) {
			if (v1.type == type) {
				if (v1.capacity > capacity)
					return 1;
				else if (v1.capacity == capacity)
					return 0;
				return -1;

			} else
				return v1.type - type;
		}

		public String toString() {
			return this.type + " - " + this.capacity;
		}

	}

	static veh2[] type1, type2;
	static int v, numOfTwos;
	static long max;

	static void maxVal(int c1) {
		if (c1 * 2 > v)
			return;
		long call = 0;
		if (c1 > type2.length)
			return;
		if (c1 != 0) {
			call = type2[c1 - 1].capacity;
		}
		int n = v - c1 * 2;
		call += maxT1(n);
		if (call > max) {
			max = call;
			numOfTwos = c1;
		}
		maxVal(c1 + 1);
	}

	static long maxT1(int n) {
		if (n <= 0)
			return 0;
		if (n > type1.length)
			n = type1.length;
		return type1[n - 1].capacity;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		v = Integer.parseInt(l[1]);
		veh2[] boxes = new veh2[n];
		int t2C = 0;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			int t = Integer.parseInt(l[0]);
			int c = Integer.parseInt(l[1]);
			boxes[i] = new veh2(i + 1, c, t);
			if (t == 2)
				t2C++;
		}
		Arrays.sort(boxes);
		type1 = null;
		type2 = null;
		if (n != t2C)
			type1 = new veh2[n - t2C];
		if (t2C != 0)
			type2 = new veh2[t2C];
		if (type1 != null) {
			type1[0] = boxes[t2C];
			int c = 1;
			for (int i = t2C + 1; i < boxes.length; i++) {
				type1[c] = boxes[i];
				type1[c].capacity += type1[c - 1].capacity;
				c++;
			}
		}
		if (type2 != null) {
			type2[0] = boxes[0];
			for (int i = 1; i < t2C; i++) {
				type2[i] = boxes[i];
				type2[i].capacity += type2[i - 1].capacity;
			}
		}
		if (type2 == null) {
			int len = Math.min(type1.length, v);
			System.out.println(type1[len - 1].capacity);
			for (int i = 0; i < len; i++) {
				System.out.print(type1[i].index + " ");
			}
		} else if (type1 == null) {
			if (v < 2)
				System.out.println(0);
			else {
				int len = Math.min(type2.length, v / 2);
				System.out.println(type2[len - 1].capacity);
				for (int i = 0; i < len; i++) {
					System.out.print(type2[i].index + " ");
				}
			}
		} else {
			maxVal(0);
			System.out.println(max);
			for (int i = 0; i < numOfTwos && i < type2.length; i++) {
				System.out.println(type2[i].index);
			}
			for (int i = 0; i < v - 2 * numOfTwos && i < type1.length; i++) {
				System.out.println(type1[i].index);
			}
		}
	}
}
