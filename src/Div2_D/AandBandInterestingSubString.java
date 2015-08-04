package Div2_D;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.HashMap;
	
	public class AandBandInterestingSubString {
		static int[] cost = new int[26];
		static long[] sum;
		static HashMap<Long, Integer> maps[] = new HashMap[26];
		static char[] curr;
	
		void solve() throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			String[] l = bf.readLine().split(" ");
			for (int i = 0; i < l.length; i++) {
				cost[i] = Integer.parseInt(l[i]);
				maps[i] = new HashMap<>();
			}
	
			curr = bf.readLine().toCharArray();
			sum = new long[curr.length];
	
			sum[0] = cost[curr[0] - 'a'];
			maps[curr[0] - 'a'].put(sum[0], 1);
	
			long ans = 0;
			for (int i = 1; i < curr.length; i++) {
				sum[i] = cost[curr[i] - 'a'] + sum[i - 1];
	
				if (maps[curr[i] - 'a'].containsKey(sum[i - 1]))
					ans += maps[curr[i] - 'a'].get(sum[i - 1]);
	
				if (!maps[curr[i] - 'a'].containsKey(sum[i]))
					maps[curr[i] - 'a'].put(sum[i], 1);
				else
					maps[curr[i] - 'a'].put(sum[i],
							maps[curr[i] - 'a'].get(sum[i]) + 1);
	
			}
			System.out.println(ans);
	
		}
	
		public static void main(String[] args) throws Exception {
			new AandBandInterestingSubString().solve();
		}
	}
