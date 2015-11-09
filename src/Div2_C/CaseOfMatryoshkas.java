package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CaseOfMatryoshkas {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		int res = 0;
		for (int i = 0; i < k; i++) {
			l = bf.readLine().split(" ");
			int numOfPiles = 1;
			int c = Integer.parseInt(l[0]);
			int curr = Integer.parseInt(l[1]);
			int numOfConsc = 1;
			int start = curr;
			for (int j = 2; j <= c; j++) {
				int a = Integer.parseInt(l[j]);
				if (a - curr == 1) {
					curr = a;
					numOfConsc++;
				} else {
					if (start != 1)
						res += (numOfConsc - 1) * 2;
					start = curr;
					numOfConsc = 1;
					curr = a;
					numOfPiles++;
				}
				
			}
			if (start != 1)
				res += (numOfConsc - 1) * 2;
			res += numOfPiles - 1;
			res += numOfPiles;
		}
		System.out.println(res - 1);
	}
}
