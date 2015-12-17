package Div1_C_Div2_E;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class DuffInArmy {
	static class Node {
		boolean init = false;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int[] arr;

		Node() {

		}

		void init() {
			arr = new int[Math.min(10, q.size())];
			int i = 0;
			while (i < arr.length) {
				arr[i++] = q.poll();
			}
			q.clear();
		}
	}

	static Node[] nodes = new Node[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node();
		}
	}
}
