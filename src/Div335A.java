import java.util.Scanner;

public class Div335A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[3];
		int goal[] = new int[3];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		goal[0] = sc.nextInt();
		goal[1] = sc.nextInt();
		goal[2] = sc.nextInt();
		int left = 0;
		for (int j = 0; j < goal.length; j++) {
			if (arr[j] > goal[j]) {
				left += (arr[j] - goal[j]) / 2;
				arr[j] = goal[j];
			}
		}
		for (int i = 0; i < goal.length; i++) {
			if (goal[i] > arr[i]) {
				int need = goal[i] - arr[i];
				if (need > left) {
					System.out.println("No");
					return;
				}
				left -= need;
			}
		}
		System.out.println("Yes");
	}
}
