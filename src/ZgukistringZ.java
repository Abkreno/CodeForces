import java.util.Scanner;

public class ZgukistringZ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aCount[] = new int[26];
		int bCount[] = new int[26];
		int cCount[] = new int[26];
		char[] a = sc.nextLine().toCharArray();
		for (int i = 0; i < a.length; i++) {
			aCount[a[i] - 'a']++;
		}
		String bb = sc.nextLine();
		char[] b = bb.toCharArray();
		for (int i = 0; i < b.length; i++) {
			bCount[b[i] - 'a']++;
		}
		String cc = sc.nextLine();
		char[] c = cc.toCharArray();
		for (int i = 0; i < c.length; i++) {
			cCount[c[i] - 'a']++;
		}
		int numOfBs = 0;
		int numOfCs = 0;
		int maxBs = a.length / b.length + 1;
		for (int i = 0; i < maxBs; i++) {
			boolean ok = true;
			for (int k = 0; k < 26; k++) {
				int need = bCount[k] * i;
				if (need > aCount[k]) {
					ok = false;
					break;
				}
			}
			int j = Integer.MAX_VALUE;
			if (ok) {
				for (int x = 0; x < 26; x++) {
					int left = aCount[x] - bCount[x] * i;
					if (cCount[x] != 0) {
						j = Math.min(j, left / cCount[x]);
					}
				}
				if (j == Integer.MAX_VALUE)
					j = 0;
				if (i + j > numOfBs + numOfCs) {
					numOfBs = i;
					numOfCs = j;
				}
			}
		}
		for (int i = 0; i < 26; i++) {
			int left = aCount[i] - bCount[i] * numOfBs;
			if (cCount[i] != 0) {
				numOfCs = Math.min(numOfCs, left / cCount[i]);
			}
		}
		if (numOfCs == Integer.MAX_VALUE)
			numOfCs = 0;
		char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < numOfBs; i++) {
			ans.append(bb);
			if (ans.length() > 5000) {
				System.out.print(ans);
				ans = new StringBuffer();
			}
		}
		for (int i = 0; i < numOfCs; i++) {
			ans.append(cc);
			if (ans.length() > 5000) {
				System.out.print(ans);
				ans = new StringBuffer();
			}
		}
		for (int i = 0; i < 26; i++) {
			aCount[i] -= bCount[i] * numOfBs + cCount[i] * numOfCs;
			for (int j = 0; j < aCount[i]; j++) {
				ans.append(abc[i]);
				if (ans.length() > 5000) {
					System.out.print(ans);
					ans = new StringBuffer();
				}
			}
		}
		ans.append("");
		System.out.println(ans);

	}
}
