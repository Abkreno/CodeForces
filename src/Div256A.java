import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Div256A {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int a1 = Integer.parseInt(l[0]);
		int a2 = Integer.parseInt(l[1]);
		int a3 = Integer.parseInt(l[2]);
		int aSum = a1 + a3 + a2;
		l = bf.readLine().split(" ");
		int b1 = Integer.parseInt(l[0]);
		int b2 = Integer.parseInt(l[1]);
		int b3 = Integer.parseInt(l[2]);
		int bSum = b1 + b2 + b3;
		int bNeed = bSum / 10;
		if (bSum % 10 != 0)
			bNeed++;
		int aNeed = aSum / 5;
		if (aSum % 5 != 0)
			aNeed++;
		int n = Integer.parseInt(bf.readLine());
		if (aNeed <= n) {
			n -= aNeed;
			if (bNeed <= n) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else
			System.out.println("NO");
	}
}
