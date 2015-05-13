import java.util.*;

public class SpreadSheet {
	static boolean check(String w) {
		if (w.charAt(0) != 'R')
			return false;
		if (abc.contains(w.charAt(1) + ""))
			return false;
		for (int i = 2; i < w.length(); i++) {
			if (w.charAt(i) == 'C')
				return true;
		}
		return false;
	}

	static String abc = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String res = "";
			String w = sc.next();
			int cInd = w.indexOf('C');
			if (check(w)) {

				int row = Integer.parseInt(w.substring(1, cInd));
				int column = Integer
						.parseInt(w.substring(cInd + 1, w.length()));
				int div = 0;
				int mod = column % 26;
				while (column >= 26) {
					div = column / 26;
					column /= 26;
					if (div > 26) {
						res += "Z";
					} else {
						res += abc.charAt(div);
					}
				}
				res += abc.charAt(mod);
				System.out.println(res + row);
			} else {
				int ind = 0;
				for (int x = 0; x < w.length(); x++) {
					if (abc.contains(w.charAt(x) + ""))
						ind++;
					else
						break;
				}
				String row = w.substring(0, ind);
				int column = Integer.parseInt(w.substring(ind, w.length()));
				int rr = 0;
				int k = 1;
				for (int j = row.length() - 1; j >= 0; j--) {
					rr += abc.indexOf(row.charAt(j)) * k;
					k *= 26;
				}
				System.out.println("R" + column + "C" + rr);

			}

		}

	}
}