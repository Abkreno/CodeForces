import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Edu2A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] line = bf.readLine().toCharArray();
		ArrayList<String> numbers = new ArrayList<>();
		ArrayList<String> b = new ArrayList<>();

		StringBuffer curr = new StringBuffer();
		boolean isNumber = true;
		for (int i = 0; i < line.length; i++) {
			if (line[i] == ',' || line[i] == ';') {
				if (curr.length() == 0)
					b.add("*");
				else if (isNumber
						&& (curr.length() == 1 || curr.charAt(0) != '0'))
					numbers.add(curr.toString());
				else
					b.add(curr.toString());
				if (i == line.length - 1)
					b.add("*");
				curr = new StringBuffer();
				isNumber = true;
			} else {
				curr.append(line[i]);
				if (line[i] < '0' || line[i] > '9')
					isNumber = false;
				if (i == line.length - 1) {
					if (curr.length() == 0)
						b.add("*");
					else if (isNumber
							&& (curr.length() == 1 || curr.charAt(0) != '0'))
						numbers.add(curr.toString());
					else
						b.add(curr.toString());
				}
			}
		}
		StringBuffer nums = new StringBuffer();
		for (int i = 0; i < numbers.size(); i++) {
			nums.append(numbers.get(i));
			if (numbers.size() != i + 1)
				nums.append(",");
		}
		StringBuffer bb = new StringBuffer();
		for (int i = 0; i < b.size(); i++) {
			bb.append(b.get(i) == "*" ? "" : b.get(i));
			if (b.size() != i + 1)
				bb.append(",");
		}

		if (nums.length() == 0)
			System.out.println("-");
		else
			System.out.println("\"" + nums + "\"");
		if (b.size() == 0 && bb.length() == 0)
			System.out.println("-");
		else
			System.out.println("\"" + bb + "\"");
	}
}
