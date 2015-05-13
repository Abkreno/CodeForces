import java.util.HashMap;
import java.util.Scanner;

public class AandBandChess {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> weights = new HashMap<>();
		weights.put('Q', 9);
		weights.put('R', 5);
		weights.put('B', 3);
		weights.put('N', 3);
		weights.put('P', 1);
		weights.put('K', 0);
		weights.put('q', 9);
		weights.put('r', 5);
		weights.put('b', 3);
		weights.put('n', 3);
		weights.put('p', 1);
		weights.put('k', 0);
		int black = 0;
		int white = 0;
		for (int i = 0; i < 8; i++) {
			char[] l = sc.nextLine().toCharArray();
			for (int j = 0; j < l.length; j++) {
				if (l[j] == '.')
					continue;
				if ((l[j] <= 'z') && (l[j] >= 'a')) {
					black += weights.get(l[j]);
				} else {
					white += weights.get(l[j]);
				}
			}
		}
		if(white>black){
			System.out.println("White");
		}else if(black>white){
			System.out.println("Black");
		}else{
			System.out.println("Draw");
		}

	}
}
