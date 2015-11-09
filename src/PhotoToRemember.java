import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class PhotoToRemember {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[];
		int[] w = new int[n];
		int[] h = new int[n];
		int totalW = 0, currW, currH;
		PriorityQueue<Integer> maxHeight = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			w[i] = Integer.parseInt(l[0]);
			h[i] = Integer.parseInt(l[1]);
			maxHeight.add(-1*h[i]);
			totalW += w[i];
		}
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < n; i++) {
			currW = totalW - w[i];
			currH = -1 * maxHeight.peek();
			if (currH == h[i]) {
				int tmp = maxHeight.poll();
				currH = -1 * maxHeight.peek();
				ans.append(currW * currH + " ");
				maxHeight.add(tmp);
			} else {
				ans.append(currW * currH + " ");
			}
		}
		System.out.println(ans);
	}
}
