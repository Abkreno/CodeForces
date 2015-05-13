import java.util.Scanner;

public class GigaTower {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n++;
		int res = 1;
		while (true) {
			if ((n + "").contains("8"))
				break;
			n++;
			res++;
		}
		System.out.println(res);
	}
}
