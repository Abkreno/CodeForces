package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GerladsHexagon {
	public static void main(String[] args) throws Exception {

		long arr[] = new long[2011];
		arr[1] = 3;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + 2;
		}
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int sides[] = new int[6];
		for (int i = 0; i < sides.length; i++) {
			sides[i] = Integer.parseInt(l[i]);
		}
		int a = sides[0];
		int b = Math.min(sides[1], sides[5]);
		long res = arr[a];
		int curr = a;
		for (int i = 1; i < b; i++) {
			res += arr[++curr];
		}

		a = sides[3];
		b = Math.min(sides[2], sides[4]);
		curr = a;
		res += arr[a];
		for (int i = 1; i < b; i++) {
			res += arr[++curr];
		}
		int y = Math.max(sides[2], sides[4]);
		int x = Math.min(sides[2], sides[4]);
		res += (x + sides[3]) * (y - x) * 2;
		System.out.println(res);
	}
}
