import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Div318A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int ans = 0;
		int curr, votes = Integer.parseInt(l[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < l.length; i++) {
			pq.add(-Integer.parseInt(l[i]));
		}
		while (true) {
			curr = -pq.poll();
			if (votes > curr)
				break;
			curr--;
			votes++;
			ans++;
			pq.add(-curr);
		}
		System.out.println(ans);
	}

}
