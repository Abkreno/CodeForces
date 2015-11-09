import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Div243A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int S = Integer.parseInt(l[1]);
		int nums[] = new int[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			sum += nums[i];
		}
		if (sum > S) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
}
