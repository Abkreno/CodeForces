import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Div317A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int a = Integer.parseInt(l[0]);
		int b = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		int k = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		int nums1[] = new int[a];
		int nums2[] = new int[b];
		l = bf.readLine().split(" ");
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = Integer.parseInt(l[i]);
		}
		l = bf.readLine().split(" ");
		for (int i = 0; i < nums2.length; i++) {
			nums2[i] = Integer.parseInt(l[i]);
		}
		int element = nums2[b - m];
		int element2 = nums1[k - 1];
		System.out.println(element2 < element?"YES":"NO");
	}
}
