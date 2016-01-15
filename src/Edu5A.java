import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Edu5A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		char[] s1 = bf.readLine().toCharArray();
		char[] s2 = bf.readLine().toCharArray();
		char[] tmp1 = s1;
		boolean allZ = true;
		for (int i = 0; i < s1.length; i++) {
			if (s1[i] != '0') {
				tmp1 = new char[s1.length - i];
				int c =0;
				for (int j = i; j < s1.length; j++) {
					tmp1[c++] = s1[j];
				}
				s1 = tmp1;
				allZ = false;
				break;
			}
		}
		if (allZ)
			s1 = new char[0];
		allZ = true;
		for (int i = 0; i < s2.length; i++) {
			if (s2[i] != '0') {
				tmp1 = new char[s2.length - i];
				int c = 0;
				for (int j = i; j < s2.length; j++) {
					tmp1[c++] = s2[j];
				}
				s2 = tmp1;
				allZ = false;
				break;
			}
		}
		if (allZ)
			s2 = new char[0];
		if (s1.length > s2.length) {
			out.println('>');
		} else if (s1.length < s2.length) {
			out.println('<');
		} else {
			for (int i = 0; i < s2.length; i++) {
				if (s1[i] > s2[i]) {
					out.println('>');
					out.flush();
					out.close();
					return;
				} else if (s1[i] < s2[i]) {
					out.println('<');
					out.flush();
					out.close();
					return;
				}
			}
			out.println('=');
		}
		out.flush();
		out.close();
	}
}
