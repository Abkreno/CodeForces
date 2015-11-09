package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CowAndSequence {
	static class P {
		int val, updated;

		P(int val) {
			this.val = val;
			this.updated = 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		P[] cows = new P[200005];
		double sum = 0;
		int index = 0;
		cows[index++] = new P(0);
		String l[];
		int n = Integer.parseInt(bf.readLine());
		StringBuffer res = new StringBuffer();
		while (n-- > 0) {
			l = bf.readLine().split(" ");
			int t = Integer.parseInt(l[0]);
			if (t == 1) {
				int range = Integer.parseInt(l[1]);
				int val = Integer.parseInt(l[2]);
				cows[range - 1].updated += val;
				sum += (range * val * 1.0);
				res.append(String.format("%.6f", sum / (index * 1.0))
						+ "\n");
			} else if (t == 2) {
				int val = Integer.parseInt(l[1]);
				cows[index++] = new P(val);
				sum += val;
				res.append(String.format("%.6f", sum / (index * 1.0))
						+ "\n");
			} else {
				P r = cows[index - 1];
				index--;
				cows[index - 1].updated += r.updated;
				sum -= (r.updated + r.val);
				res.append(String.format("%.6f", sum / (index * 1.0))
						+ "\n");
			}
		}
		System.out.print(res);
	}

}
