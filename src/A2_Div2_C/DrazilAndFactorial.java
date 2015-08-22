package A2_Div2_C;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class DrazilAndFactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char[] num = sc.nextLine().toCharArray();
		LinkedList<Integer> nums = new LinkedList<>();
		for (int i = 0; i < num.length; i++) {
			if (num[i] == '4') {
				nums.add(2);
				nums.add(2);
				nums.add(3);
			} else if (num[i] == '6') {
				nums.add(3);
				nums.add(5);
			} else if (num[i] == '8') {
				nums.add(2);
				nums.add(2);
				nums.add(2);
				nums.add(7);
			} else if (num[i] == '9') {
				nums.add(3);
				nums.add(3);
				nums.add(2);
				nums.add(7);
			} else if (num[i] != '0' && num[i] != '1') {
				nums.add(num[i] - '0');
			}
		}
		Collections.sort(nums);
		while (!nums.isEmpty())
			System.out.print(nums.removeLast());
		System.out.println();
	}
}
