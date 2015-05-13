import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class SumsOfDigits {
	static int nums[];
	static Stack<Integer> res;

	static int DP[];

	public static void main(String[] args) {
		DP = new int[1000001];
		PriorityQueue[] values = new PriorityQueue[1000001];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i = 0; i < 10; i++) {
			DP[i] = i;
			if (values[DP[i]] == null) {
				values[DP[i]] = new PriorityQueue<Integer>();
			}
			values[DP[i]].add(i);
		}
		int len = 2;
		for (int i = 10; i < DP.length; i++) {
			len = (i + "").length();
			int pow = (int) Math.pow(10, len - 1);
			DP[i] = (i / pow) + DP[i % pow];
			if (values[DP[i]] == null) {
				values[DP[i]] = new PriorityQueue<Integer>();
			}
			values[DP[i]].add(i);
		}
		int curr = 0;
		int prev = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			PriorityQueue<Integer> kkk = values[nums[i]];
			while ((curr = (int) values[nums[i]].poll()) < prev) {
			}
			prev = curr;
			System.out.println(curr);
		}

	}
}
