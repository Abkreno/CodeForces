import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class WinnieAndHoney {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		PrintStream out = new PrintStream(new File("output.txt"));
		int n = sc.nextInt();
		int k = sc.nextInt();
		int nums[] = new int[n];
		int count, res = 0;

		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
			count = 0;
			while (count++ < 3 && nums[i] >= k) {
				nums[i] -= k;
			}
			res += nums[i];
		}
		out.println(res);
		out.close();
	}
}
