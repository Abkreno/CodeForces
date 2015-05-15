package Div277;

public class test {
	private static int calcDist(char c, char d) {
		int normal = Math.abs(c - d);
		int reverse = 'z' - d + c + 1;
		reverse -= 'a';
		return Math.min(reverse, normal);
	}

	public static void main(String[] args) {
		System.out.println(calcDist('a', 'z'));
	}
}
