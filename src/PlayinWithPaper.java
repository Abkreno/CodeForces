import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PlayinWithPaper {
	static int arr[];
	static int n = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(minVal('b', 'z'));
	}

	private static int minVal(char c, char d) {
		int c1 = c - 'a';
		int d1 = d - 'a';
		return Math.min(Math.abs(c1 - d1),
				26 - Math.max(c1, d1) + Math.min(c1, d1));
	}

	static int lowerBound(int val) {
		int low = 0;
		int high = n - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			int midVal = arr[mid];
			if (midVal < val)
				low = mid + 1;
			else if (midVal > val)
				high = mid - 1;
			else if (low != mid)
				high = mid;
			else
				break;
		}
		System.out.println(low);
		System.out.println(high);
		return low;
	}
}
