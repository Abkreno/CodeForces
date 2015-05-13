import java.util.Scanner;

public class SumsOfDigits2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String Table[] = new String[301];
		for (int i = 1; i <= 300; i++) {
			int sumSoFar = 0;
			String curr = "";
			while (sumSoFar < i) {
				for (int j = 9; j >= 0; j--) {
					if (sumSoFar + j <= i) {
						curr += j;
						sumSoFar += j;
						break;
					}
				}
			}
			Table[i] = curr;
		}
		int n = sc.nextInt();
		String prev = "0";
		for (int i = 0; i < n; i++) {
			int curr = sc.nextInt();
			while (Table[curr].charAt(0) < prev.charAt(0)
					&& Table[curr].length() <= prev.length())
				Table[curr] += "0";
			System.out.println(Table[curr]);
			prev = Table[curr];
			Table[curr] += "0";
		}
	}
}
