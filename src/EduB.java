import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EduB {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = bf.readLine().toCharArray();
		char[] temp = new char[arr.length];
		char[] temp2 = new char[arr.length];
		int a, b, k, mod, m = Integer.parseInt(bf.readLine());
		String[] l;
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			k = Integer.parseInt(l[2]);
			int c = 0;
			for (int j = a; j <= b; j++) {
				temp[c++] = arr[j];
			}
			mod = b - a + 1;
			for (int j = 0; j < c; j++) {
				temp2[(j + k) % mod] = temp[j];
			}
			c = 0;
			for (int j = a; j <= b; j++) {
				arr[j] = temp2[c++];
			}
		
		}
		System.out.println(String.valueOf(arr));
	}
}
