package Div1_C_Div2_E;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SquareRootOfPermutation {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		if(n==1){
			System.out.println(1);
			return;
		}
		String[] l = bf.readLine().split(" ");
		int nums[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		int index[] = new int[n];
		int curr = 0, c, guess;
		for (int i = 6; i <= n; i++) {
			Arrays.fill(index, -1);
			c = 0;
			guess = i;
			curr = 1;
			while (c < n) {
				if (index[curr - 1] == -1) {
					index[curr - 1] = guess;
					int tmp = curr;
					curr = guess;
					guess = nums[tmp - 1];
					c++;
				} else
					break;
			}
			if (c == n) {
				StringBuffer b = new StringBuffer();
				for (int j = 0; j < index.length; j++) {
					b.append(index[j] + " ");
				}
				System.out.println(b);
				return;
			}
		}
		System.out.println(-1);
	}
}
