package A2_Div2_C;

import java.util.Scanner;

public class DiversePermutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int largest = n;
		int smallest = 1;
		boolean altr = true;
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < k ; i++) {
			if (altr)
				ans.append((largest--) + " ");
			else
				ans.append((smallest++) + " ");
			altr = !altr;
		}
		if (altr) {
			for (int i = smallest; i <= largest; i++) {
				ans.append(i + " ");
			}
		} else {
			for (int i = largest; i >= smallest; i--) {
				ans.append(i + " ");
			}
		}
		System.out.println(ans);
	}
}
