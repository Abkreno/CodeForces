import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Div339B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		long nums[] = new long[m];
		BigInteger ans = BigInteger.ONE;
		BigInteger curr;
		int numOfZeros = 0;
		int totalZeros = 0;
		StringBuffer odd = new StringBuffer("1");
		for (int i = 0; i < nums.length; i++) {
			if (l[i].charAt(0) == '0') {
				System.out.println(0);
				return;
			}
			numOfZeros = beatiful(l[i].toCharArray());
			if (numOfZeros == -1)
				odd = new StringBuffer(l[i]);
			else {
				totalZeros += numOfZeros;
			}
		}
		for (int i = 0; i < totalZeros; i++) {
			odd.append('0');
		}
		System.out.println(odd);
	}

	private static int beatiful(char[] str) {
		int numOfOnes = 0;
		int numOfZeros = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] > '1')
				return -1;
			if (str[i] == '1') {
				numOfOnes++;
				if (numOfOnes > 1)
					return -1;
			} else if (str[i] == '0')
				numOfZeros++;
		}
		return numOfZeros;
	}
}
