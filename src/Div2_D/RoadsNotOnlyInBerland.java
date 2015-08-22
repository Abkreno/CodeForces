package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class RoadsNotOnlyInBerland {
	static class DSU {

		private int[] parent; // parent[i] = parent of i
		private byte[] rank; // rank[i] = rank of subtree rooted at i (never
								// more than 31)
		private int count; // number of components

		/**
		 * Initializes an empty union-find data structure with <tt>N</tt>
		 * isolated components <tt>0</tt> through <tt>N-1</tt>.
		 * 
		 * @param N
		 *            the number of sites
		 * @throws java.lang.IllegalArgumentException
		 *             if <tt>N &lt; 0</tt>
		 */
		public DSU(int N) {
			if (N < 0)
				throw new IllegalArgumentException();
			count = N;
			parent = new int[N];
			rank = new byte[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}

		/**
		 * Returns the component identifier for the component containing site
		 * <tt>p</tt>.
		 * 
		 * @param p
		 *            the integer representing one object
		 * @return the component identifier for the component containing site
		 *         <tt>p</tt>
		 * @throws java.lang.IndexOutOfBoundsException
		 *             unless <tt>0 &le; p &lt; N</tt>
		 */
		public int find(int p) {
			if (p < 0 || p >= parent.length)
				throw new IndexOutOfBoundsException();
			while (p != parent[p]) {
				parent[p] = parent[parent[p]]; // path compression by halving
				p = parent[p];
			}
			return p;
		}

		/**
		 * Returns the number of components.
		 * 
		 * @return the number of components (between <tt>1</tt> and <tt>N</tt>)
		 */
		public int count() {
			return count;
		}

		/**
		 * Are the two sites <tt>p</tt> and <tt>q</tt> in the same component?
		 * 
		 * @param p
		 *            the integer representing one site
		 * @param q
		 *            the integer representing the other site
		 * @return true if the two sites <tt>p</tt> and <tt>q</tt> are in the
		 *         same component; false otherwise
		 * @throws java.lang.IndexOutOfBoundsException
		 *             unless both <tt>0 &le; p &lt; N</tt> and
		 *             <tt>0 &le; q &lt; N</tt>
		 */
		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		/**
		 * Merges the component containing site <tt>p</tt> with the the
		 * component containing site <tt>q</tt>.
		 * 
		 * @param p
		 *            the integer representing one site
		 * @param q
		 *            the integer representing the other site
		 * @throws java.lang.IndexOutOfBoundsException
		 *             unless both <tt>0 &le; p &lt; N</tt> and
		 *             <tt>0 &le; q &lt; N</tt>
		 */
		public void union(int p, int q) {
			int rootP = find(p);
			int rootQ = find(q);
			if (rootP == rootQ)
				return;

			// make root of smaller rank point to root of larger rank
			if (rank[rootP] < rank[rootQ])
				parent[rootP] = rootQ;
			else if (rank[rootP] > rank[rootQ])
				parent[rootQ] = rootP;
			else {
				parent[rootQ] = rootP;
				rank[rootP]++;
			}
			count--;
		}

	}

	static class Construct {
		int from, to;

		Construct(int i, int j) {
			from = i;
			to = j;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		DSU set = new DSU(1001);
		int a, b, n = Integer.parseInt(bf.readLine());
		String[] l;
		LinkedList<Construct> useless = new LinkedList<>();
		for (int i = 0; i < n - 1; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]);
			b = Integer.parseInt(l[1]);
			if (set.find(a) == set.find(b)) {
				useless.add(new Construct(a, b));
			} else {
				set.union(a, b);
			}
		}
		int curr = 0;
		StringBuffer ans = new StringBuffer();
		Construct c;
		for (int i = 2; i <= n; i++) {
			if (set.find(1) != set.find(i)) {
				c = useless.get(curr++);
				ans.append(c.from + " " + c.to + " " + 1 + " " + i + "\n");
				set.union(1, i);
			}
		}
		System.out.println(curr);
		System.out.print(ans);

	}

}
