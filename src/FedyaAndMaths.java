import java.util.Scanner;

public class FedyaAndMaths {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] n = sc.nextLine().toCharArray();
		int mod = divisbleByLeftToRight(n, 4);
		int res = 0;
		for (int i = 1; i <= 4; i++) {
			res += pow(i, mod);
		}
		System.out.println(res % 5);
	}

	static int pow(int i, int p) {
		if (p == 0)
			return 1;
		return i * pow(i, p - 1);
	}

	static int divisbleByLeftToRight(char[] a, int b) {
		int prefixMod = (a[0] - '0') % b;
		for (int i = 1; i < a.length; i++) {
			prefixMod = (prefixMod * 10 + (a[i] - '0')) % b;
		}
		return prefixMod;
	}
}
