package Div2_C;

import java.math.BigInteger;
import java.util.Scanner;

public class TheBigRace {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong();
		long w = sc.nextLong();
		long b = sc.nextLong();

		long min = Math.min(w, b);
		if (w == b || min > t) {
			System.out.println("1/1");
			return;
		}

		long ans = Math.min(t, min - 1);
		BigInteger T = new BigInteger(t + "");
		BigInteger W = new BigInteger(w + "");
		BigInteger B = new BigInteger(b + "");
		BigInteger C = W.multiply(B);
		C = C.divide(W.gcd(B));
		BigInteger M = new BigInteger(min + "");
		BigInteger ANS = new BigInteger(ans + "");
		BigInteger TMP = T.divide(C);
		TMP = TMP.subtract(BigInteger.ONE);
		TMP = TMP.multiply(M);
		ANS = ANS.add(TMP);
		TMP = T.mod(C);
		TMP = TMP.add(BigInteger.ONE);
		if (TMP.compareTo(M) > 0) {
			ANS = ANS.add(M);
		} else {
			ANS = ANS.add(TMP);
		}
		BigInteger GCD = ANS.gcd(T);
		ANS = ANS.divide(GCD);
		T = T.divide(GCD);
		System.out.println(ANS + "/" + T);
	}
}