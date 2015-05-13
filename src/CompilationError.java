import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompilationError {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int line1[] = new int[n];
		String l[] = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			line1[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(line1);
		l = bf.readLine().split(" ");
		int line2[] = new int[n - 1];
		for (int i = 0; i < l.length; i++) {
			line2[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(line2);
		for (int i = 0; i < line2.length; i++) {
			if (line2[i] != line1[i]) {
				System.out.println(line1[i]);
				break;
			} else if (i == line2.length - 1) {
				System.out.println(line1[i + 1]);
			}
		}
		line1 = new int[n - 2];
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			line1[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(line1);
		for (int i = 0; i < line1.length; i++) {
			if (line2[i] != line1[i]) {
				System.out.println(line2[i]);
				break;
			} else if (i == line1.length - 1) {
				System.out.println(line2[i + 1]);
			}
		}
	}
}
