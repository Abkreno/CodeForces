import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Div249B {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		char[] n = l[0].toCharArray();
		int k = Integer.parseInt(l[1]);
		int currPos, bestPos, bestInd;
		for (int x = 0; x < n.length; x++) {
			bestPos = 1000;
			bestInd = -1;
			for (int i = 0; i < n.length; i++) {
				currPos = i;
				for (int j = i - 1; j >= 0; j--) {
					if (n[i] <= n[j])
						break;
					if (i - j > k)
						break;
					currPos--;
				}
				if (currPos == i)
					continue;
				if (currPos < bestPos) {
					bestPos = currPos;
					bestInd = i;
				} else if (currPos == bestPos && n[bestInd] < n[i]) {
					bestPos = currPos;
					bestInd = i;
				}
			}
			if (bestInd == -1) {
				continue;
			} else {
				for (int j = bestInd; j > bestPos; j--) {
					char tmp = n[j];
					n[j] = n[j - 1];
					n[j - 1] = tmp;
				}
				k -= bestInd - bestPos;
				if (k <= 0)
					break;
			}
		}
		System.out.println(String.valueOf(n));
	}
}
