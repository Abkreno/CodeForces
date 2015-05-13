package Dev283;

import java.util.LinkedList;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		String n = sc.next();
		LinkedList<Integer> num = new LinkedList<Integer>();
		LinkedList<Integer> minArr = new LinkedList<Integer>();
		for (int i = 0; i < nn; i++) {
			num.add(n.charAt(i) - '0');
			minArr.add(n.charAt(i) - '0');
		}
		for (int c = 0; c < 10; c++) {
			for (int i = 0; i < nn + 1; i++) {
				num.addFirst(num.removeLast());
				int k = 0;
				while (k < nn && num.get(k) == minArr.get(k))
					k++;
				if (k < nn && num.get(k) < minArr.get(k)) {
					minArr = new LinkedList<Integer>();
					for (int x : num) {
						minArr.add(x);
					}
				}
			}
			for (int i = 0; i < nn; i++) {
				int x = num.remove(i);
				num.add(i, (x + 1) % 10);
			}

		}
		for (int x : minArr) {
			System.out.print(x);
		}
	}
}
