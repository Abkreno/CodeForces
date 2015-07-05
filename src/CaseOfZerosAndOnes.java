import java.util.Scanner;

public class CaseOfZerosAndOnes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char[] s = sc.next().toCharArray();
		int res = 0;
		int i = 1;
		int numOfPrev = 1;
		char curr = s[0];
		while (i < n) {
			if (s[i] != curr) {
				res += 2;
				numOfPrev--;
				i++;
				if(i>=n)break;
				if (numOfPrev == 0) {
					curr = s[i];
					numOfPrev = 1;
					i++;
				}
			} else {
				numOfPrev++;
				i++;
			}
		}
		System.out.println(Math.max(n - res,0));
	}
}
