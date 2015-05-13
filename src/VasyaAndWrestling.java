import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VasyaAndWrestling {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l = "";
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		boolean lastisFirst = false;
		int n = Integer.parseInt(bf.readLine());
		long sum1 = 0;
		long sum2 = 0;
		while (n-- > 0) {
			l = bf.readLine();
			int x = Integer.parseInt(l);
			if (x > 0) {
				first.add(x);
				lastisFirst = true;
				sum1 += (long)x;
			} else {
				second.add(-1 * x);
				lastisFirst = false;
				sum2 += (long)(x * -1);
			}
		}
		if (sum1 == sum2) {
			int firstSize = first.size();
			int secSize = second.size();
			boolean equal = true;
			for (int i = 0; i < Math.min(firstSize, secSize); i++) {
				int val1 = first.get(i);
				int val2 = second.get(i);
				if (val1 == val2) {
					continue;
				} else if (val1 > val2) {
					System.out.println("first");
					equal = false;
					break;
				} else {
					System.out.println("second");
					equal = false;
					break;
				}
			}
			if (equal) {
				if (firstSize == secSize) {
					System.out.println(lastisFirst ? "first" : "second");
				} else if (firstSize > secSize) {
					System.out.println("first");
				} else {
					System.out.println("second");
				}
			}
		} else if (sum1 > sum2) {
			System.out.println("first");
		} else {
			System.out.println("second");
		}

	}
}
