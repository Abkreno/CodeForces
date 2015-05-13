package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class History {
	static class date implements Comparable<date> {
		int s, e;

		date(int i, int j) {
			s = i;
			e = j;
		}

		@Override
		public int compareTo(date o) {
			if (s > o.s)
				return 1;
			else if (s < o.s)
				return -1;
			return 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		date[] arr = new date[n];
		String[] l;
		for (int i = 0; i < arr.length; i++) {
			l = bf.readLine().split(" ");
			int x = Integer.parseInt(l[0]);
			int y = Integer.parseInt(l[1]);
			arr[i] = new date(x, y);
		}
		Arrays.sort(arr);

		int res = 0;
		int min = arr[0].e;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].e < min)
				res++;
			else
				min = arr[i].e;
		}
		System.out.println(res);
	}
}
