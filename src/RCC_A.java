import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RCC_A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int c = Integer.parseInt(l[0]);
		int d = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		int k = Integer.parseInt(bf.readLine());
		int minUsed = Integer.MAX_VALUE;
		for (int main = 0; main <= 10000; main++) {
			for (int add = 0; add <= 10000; add++) {
				if ((main / c) * n + (add / d) + k >= n * m) {
					minUsed = Math.min(minUsed, main + add);
				}
			}
		}
		System.out.println(minUsed);
	}
}
