import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div323B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(l[i]);
		}
		int have = 0;
		boolean right = true;
		int ans = 0;
		while (true) {
			if (right) {
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] != -1 && arr[i] <= have) {
						have++;
						arr[i] = -1;
					}
				}
			} else {
				for (int i = n - 1; i >= 0; i--) {
					if (arr[i] != -1 && arr[i] <= have) {
						have++;
						arr[i] = -1;
					}
				}
			}
			right = !right;
			if (!done(arr))
				ans++;
			else
				break;
		}
		System.out.println(ans);
	}

	private static boolean done(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1)
				return false;
		}
		return true;
	}
}
