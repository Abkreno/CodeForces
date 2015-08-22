import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PiB {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l;
		boolean[] whereHere = new boolean[1000001];
		int max = 0, curr;
		int here = 0;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			curr = Integer.parseInt(l[1]);
			if (l[0].charAt(0) == '+') {
				whereHere[curr] = true;
				here++;
				max = Math.max(here, max);
			} else {
				if (!whereHere[curr])
					max++;
				else {
					here--;
					whereHere[curr] = false;
				}
			}
		}

		System.out.println(max);
	}
}