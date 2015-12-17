package testRound;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
	static class Order implements Comparable<Order> {
		int r, l;

		Order(int a, int b) {
			r = a;
			l = b;
		}

		@Override
		public int compareTo(Order arg0) {
			return Integer.compare(l, arg0.l);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l;
		Order[] arr = new Order[n];
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			arr[i] = new Order(Integer.parseInt(l[0]), Integer.parseInt(l[1]));
		}
		Arrays.sort(arr);
		int res = 1;
		int lastL = arr[0].l;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].r > lastL){
				res++;
				lastL = arr[i].l;
			}
		}
		System.out.println(res);
	}
}
