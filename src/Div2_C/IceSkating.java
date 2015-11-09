package Div2_C;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class IceSkating {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		LinkedList<LinkedList<Point>> sets = new LinkedList<LinkedList<Point>>();
		for (int i = 0; i < n; i++) {
			String l[] = bf.readLine().split(" ");
			int x = Integer.parseInt(l[0]);
			int y = Integer.parseInt(l[1]);
			int count = 0;
			boolean flag = false;
			LinkedList<Point> parent = null;
			loop: for (LinkedList<Point> curr : sets) {
				for (Point currP : curr) {
					if (currP.x == x || currP.y == y) {
						curr.add(new Point(x, y));
						flag = true;
						parent = curr;
						count++;
						break loop;
					}
				}
				count++;
			}
			if (flag) {
				for (int j = count; j < sets.size(); j++) {
					LinkedList<Point> curr = sets.get(j);
					boolean belongs = false;
					for (Point currP : curr) {
						if (currP.x == x || currP.y == y) {
							belongs = true;
							break;
						}
					}
					if (belongs) {
						curr = sets.remove(j--);
						for (int k = 0; k < curr.size(); k++) {
							parent.add(curr.get(k));
						}
					}
				}
			} else {
				LinkedList<Point> list = new LinkedList<Point>();
				list.add(new Point(x, y));
				sets.add(list);
			}
		}
		System.out.println(sets.size() - 1 >= 0 ? sets.size() - 1 : 0);
	}
}
