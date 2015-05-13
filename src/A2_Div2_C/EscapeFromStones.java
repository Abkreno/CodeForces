package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EscapeFromStones {
	static class Node {
		int val;
		Node next, prev;

		Node(int val) {
			this.val = val;
			next = null;
			prev = null;
		}

		boolean equals(Node o) {
			return o.val == val;
		}
	}

	static class List {
		Node root, curr;

		List(Node r) {
			root = r;
			curr = root;
		}

		void insertAfterCurr(Node n) {
			Node temp = curr.next;
			curr.next = n;
			n.prev = curr;
			n.next = temp;
			if (temp != null)
				temp.prev = n;
			curr = n;
		}

		void insertBeforeCurr(Node n) {
			Node temp = curr.prev;
			curr.prev = n;
			n.next = curr;
			n.prev = temp;
			if (temp != null)
				temp.next = n;
			else
				root = n;
			curr = n;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] stones = bf.readLine().toCharArray();
		int c = 1;
		List l = new List(new Node(c++));
		for (int i = 0; i < stones.length - 1; i++) {
			if (stones[i] == 'l') {
				l.insertBeforeCurr(new Node(c++));
			} else {
				l.insertAfterCurr(new Node(c++));
			}
		}
		Node curr = l.root;
		StringBuffer sb = new StringBuffer();
		while (curr != null) {
			sb.append(curr.val + "\n");
			curr = curr.next;
		}
		System.out.print(sb);
	}
}
