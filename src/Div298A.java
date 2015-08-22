import java.util.LinkedList;
import java.util.Scanner;

public class Div298A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		int diff = n - 1;
		if (n == 1) {
			System.out.println(1);
			System.out.println(1);
			return;
		}
		LinkedList<Integer> list = new LinkedList<>();
		list.add(n);
		boolean sub = true;
		int last = n;
		for (int i = diff; i >= 1; i--) {
			list.add(sub ? last - i : last + i);
			last = sub ? last - i : last + i;
			sub = !sub;
		}
		last = list.removeLast();
		if (list.getFirst() - last > 1)
			list.addFirst(last);
		System.out.println(list.size());
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
