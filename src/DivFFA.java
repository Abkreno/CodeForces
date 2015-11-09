import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DivFFA {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int p = Integer.parseInt(l[0]);
		int n = Integer.parseInt(l[1]);
		int arr[] = new int[p];
		Arrays.fill(arr, -1);
		for (int i = 0; i < n; i++) {
			int curr = Integer.parseInt(bf.readLine());
			if (arr[curr % p] != -1) {
				System.out.println(i+1);
				return;
			} else {
				arr[curr % p] = curr;
			}
		}
		System.out.println(-1);
	}
}
