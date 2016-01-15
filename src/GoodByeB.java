import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoodByeB {
	static long a, b;

	static long count(long nA, long prevA) {
		// System.out.println(Long.toBinaryString(nA));
		long i = 1;
		long x, res = 0;
		while (i < nA) {
			x = nA ^ i;
			if (x <= b && x >= a && x > prevA)
				res++;
			i <<= 1L;
		}
		if (nA > b)
			return res;
		else {
			return res + count(nA ^ i, nA);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		a = Long.parseLong(l[0]);
		if (a == 1)
			a = 2;
		b = Long.parseLong(l[1]);
		char[] aa = Long.toBinaryString(a).toCharArray();
		for (int i = aa.length - 1; i >= 0; i--) {
			if (aa[i] == '0') {
				aa[i] = '1';
			}
		}
		long nA = Long.parseLong(String.valueOf(aa), 2);
		System.out.println(count(nA, 0));
	}
}
