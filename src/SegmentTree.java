import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SegmentTree {
	private int[] tree = new int[5 * 100000 + 10];

	private final int STARTINDEX = 0;
	private final int ENDINDEX;
	private final int ROOT = 0;

	public SegmentTree(int size) {
		ENDINDEX = size - 1;
	}

	private int leftchild(int pos) {
		return 2 * pos + 1;
	}

	private int rightchild(int pos) {
		return 2 * pos + 2;
	}

	private int mid(int start, int end) {
		return (start + (end - start) / 2);
	}

	private int getSumUtil(int startIndex, int endIndex, int queryStart,
			int queryEnd, int current) {
		if (queryStart <= startIndex && queryEnd >= endIndex) {
			return tree[current];
		}
		if (endIndex < queryStart || startIndex > queryEnd) {
			return 0;
		}
		int mid = mid(startIndex, endIndex);
		return Math.max(
				getSumUtil(startIndex, mid, queryStart, queryEnd,
						leftchild(current)),
				getSumUtil(mid + 1, endIndex, queryStart, queryEnd,
						rightchild(current)));
	}

	public int getSum(int queryStart, int queryEnd) {
		if (queryStart < 0 || queryEnd > tree.length) {
			return -1;
		}
		return getSumUtil(STARTINDEX, ENDINDEX, queryStart, queryEnd, ROOT);
	}

	private void constructSegmentTreeUtil(int[] elements, int startIndex,
			int endIndex, int current) {
		if (startIndex == endIndex) {
			tree[current] = elements[startIndex];
			return;
		}
		int mid = mid(startIndex, endIndex);
		constructSegmentTreeUtil(elements, startIndex, mid, leftchild(current));
		constructSegmentTreeUtil(elements, mid + 1, endIndex,
				rightchild(current));
		tree[current] = Math.max(tree[leftchild(current)],
				tree[rightchild(current)]);
		return;
	}

	public void constructSegmentTree(int[] elements) {
		constructSegmentTreeUtil(elements, STARTINDEX, ENDINDEX, ROOT);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int nums[] = new int[n];
		int c, max;
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		StringBuilder sb = new StringBuilder();
		SegmentTree segmentTree = new SegmentTree(n);
		segmentTree.constructSegmentTree(nums);
		for (int i = 0; i < nums.length; i++) {
			max = segmentTree.getSum(i + 1, n);
			c = max - nums[i] + 1;
			if (c < 0)
				c = 0;
			sb.append(c + " ");
		}
		System.out.println(sb);
	}
}
