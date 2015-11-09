import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrisonTransfer {
	static int INF = Integer.MIN_VALUE;
	static int nums[], segTree[] = new int[2 * 5 * 100000];
	static int N;

	static void init() {
		Arrays.fill(segTree, INF);
		build(0, 0, N - 1);
	}

	static void build(int node, int l, int r) {
		if (l == r) {
			segTree[node] = nums[l];
			return;
		}
		int mid = (l + r) >> 1;
		build(node * 2 + 1, l, mid);
		build(node * 2 + 2, mid + 1, r);
		segTree[node] = Math.max(segTree[node * 2 + 1], segTree[node * 2 + 2]);
	}

	static int query(int node, int l, int r, int i, int j) {
		if (l > j || r < i)
			return INF;
		if (l >= i && r <= j)
			return segTree[node];
		int mid = (l + r) >> 1;
		return Math.max(query(node * 2 + 1, l, mid, i, j),
				query(node * 2 + 2, mid + 1, r, i, j));
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		N = Integer.parseInt(l[0]);
		int t = Integer.parseInt(l[1]);
		int c = Integer.parseInt(l[2]);
		l = bf.readLine().split(" ");
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		init();
		int ans = 0, q;
		for (int i = 0; i + c <= N; i++) {
			q = query(0, 0, N - 1, i, i + c-1);
			//System.out.println(i + " " + q);
			if (q <= t)
				ans++;
		}
		System.out.println(ans);
	}
}
