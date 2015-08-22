package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Handshakes {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		LinkedList<Integer> counts[] = new LinkedList[n + 1];
		for (int i = 0; i < counts.length; i++) {
			counts[i] = new LinkedList<>();
		}
		int curr;
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			curr = Integer.parseInt(l[i]);
			if (curr > n) {
				System.out.println("Impossible");
				return;
			}
			counts[curr].add(i + 1);
		}
		int count = 0;
		StringBuilder sb = new StringBuilder();
		loop: while (true) {
			while (counts[count].size() == 0) {
				count -= 3;
				if (count < 0)
					break loop;
			}
			curr = counts[count].removeFirst();
			sb.append(curr + " ");
			count++;
			if (count > n) {
				count -= 3;
			}
		}
		for (int i = 0; i < counts.length; i++) {
			if (counts[i].size() > 0) {
				System.out.println("Impossible");
				return;
			}
		}
		System.out.println("Possible");
		System.out.println(sb);
	}
}
