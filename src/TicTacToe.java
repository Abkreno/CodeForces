import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
	static char[][] grid;
	static String playerTurn, winner, first = "the first player won",
			second = "the second player won";
	static boolean draw;

	static boolean checkIllegal() {
		int oC = 0;
		int xC = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == '0')
					oC++;
				else if (grid[i][j] == 'X')
					xC++;
			}
		}
		if (oC > xC)
			return true;
		if (xC - oC > 1)
			return true;
		int winnerC = 0;
		for (int i = 0; i < 3; i++) {
			if (grid[i][0] != '.' && grid[i][0] == grid[i][1]
					&& grid[i][1] == grid[i][2]) {
				if (grid[i][0] == '0' && xC > oC)
					return true;
				else if (grid[i][0] == 'X' && oC >= xC)
					return true;
				winnerC++;
				winner = grid[i][0] == 'X' ? first : second;
			}
		}
		if (winnerC > 1)
			return true;
		winnerC = 0;
		for (int i = 0; i < 3; i++) {
			if (grid[0][i] != '.' && grid[0][i] == grid[1][i]
					&& grid[1][i] == grid[2][i]) {
				if (grid[0][i] == '0' && xC > oC)
					return true;
				else if (grid[0][i] == 'X' && oC >= xC)
					return true;
				winnerC++;
				winner = grid[0][i] == 'X' ? first : second;
			}
		}
		if (winnerC > 1)
			return true;
		if (grid[1][1] != '.') {
			if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
				if (grid[0][0] == '0' && xC > oC)
					return true;
				else if (grid[0][0] == 'X' && oC >= xC)
					return true;
				winner = grid[0][0] == 'X' ? first : second;
			}
			if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
				if (grid[2][0] == '0' && xC > oC)
					return true;
				else if (grid[2][0] == 'X' && oC >= xC)
					return true;
				winner = grid[0][2] == 'X' ? first : second;
			}
		}
		if (xC == 5 && oC == 4)
			draw = true;
		if (xC == oC)
			playerTurn = "first";
		else
			playerTurn = "second";
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		grid = new char[3][3];
		for (int i = 0; i < 3; i++) {
			grid[i] = bf.readLine().toCharArray();
		}
		if (checkIllegal()) {
			System.out.println("illegal");
		} else if (winner != null) {
			System.out.println(winner);
		} else if (draw) {
			System.out.println("draw");
		} else {
			System.out.println(playerTurn);
		}
	}
}
