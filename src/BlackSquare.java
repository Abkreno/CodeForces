import java.util.Scanner;

public class BlackSquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] l = sc.nextLine().split(" ");
		int nums[] = new int[4];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		char[] ff = sc.nextLine().toCharArray();
		int res = 0;
		for (int i = 0; i < ff.length; i++) {
			res += nums[ff[i] - '0' - 1];
		}
		System.out.println(res);
	}
}
