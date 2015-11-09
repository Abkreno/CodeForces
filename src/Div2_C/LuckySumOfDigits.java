package Div2_C;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LuckySumOfDigits {
	static int n, m;

	static void rec() {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int curr = n;
		boolean flag = false;
		boolean ret = false;
		boolean flags[] = new boolean[m];
		while (true) {
			if (!ret) {
				stack.push(curr);
				stack.push(i);
				flags[i] = false;
				curr -= 7;
				i++;
			} else {
				flags[i] = true;
				curr -= 4;
				i++;
				ret = false;
			}
			if (curr == 0 && i <= m) {
				flag = true;
				break;
			}
			if (curr < 0 || i > m) {
				if (stack.isEmpty())
					break;
				i = stack.pop();
				curr = stack.pop();
				ret = true;
			}
		}
		if (flag) {
			char[] arr = new char[i];
			for (int j = 0; j < i; j++) {
				arr[j] = flags[j] ? '4' : '7';
			}
			Arrays.sort(arr);
			StringBuffer sb = new StringBuffer("");
			for (int j = 0; j < i; j++) {
				sb.append(arr[j]);
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = (n / 4) + 1;
		// rec();
		int A = n / 4 + 1;
		int B = n / 7 + 1;
		boolean flag = false;
		for (int a = 0; a < A; a++) {
			for (int b = 0; b < B; b++) {
				if (a * 4 + b * 7 == n) {
					flag = true;
					A = a;
					B = b;
				}
			}
		}
		if (flag) {
			StringBuilder ans = new StringBuilder("");
			for (int i = 0; i < A; i++) {
				ans.append(4);
			}
			for (int i = 0; i < B; i++) {
				ans.append(7);
			}
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
		sc.close();
	}
}
