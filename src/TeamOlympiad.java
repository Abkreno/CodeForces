import java.util.LinkedList;
import java.util.Scanner;

public class TeamOlympiad {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> nums[] = new LinkedList[3];
		nums[0] = new LinkedList<Integer>();
		nums[1] = new LinkedList<Integer>();
		nums[2] = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			int curr = sc.nextInt();
			nums[curr - 1].add(i + 1);
		}
		int minSize = 5000;
		for (int i = 0; i < nums.length; i++) {
			minSize = Math.min(minSize, nums[i].size());
		}
		System.out.println(minSize);
		for (int i = 0; i < minSize; i++) {
			System.out.println(nums[0].remove() + " " + nums[1].remove() + " "
					+ nums[2].remove());
		}
	}
}
