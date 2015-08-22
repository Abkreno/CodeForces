import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class Div285B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l;
		HashMap<String, LinkedList<String>> map = new HashMap<>();
		HashSet<String> used = new HashSet<>();
		LinkedList<String> tmp;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			if (!map.containsKey(l[0])) {
				tmp = new LinkedList<>();
				tmp.add(l[0]);
				map.put(l[0], tmp);
			} else {
				tmp = map.get(l[0]);
			}
			if (used.contains(l[1])) {

			} else {
				tmp.addLast(l[1]);
				map.remove(l[0]);
				map.put(l[1], tmp);
				used.add(l[1]);
			}
		}
		Iterator<Entry<String, LinkedList<String>>> it = map.entrySet()
				.iterator();
		int res = 0;
		StringBuffer sb = new StringBuffer();
		while (it.hasNext()) {
			Entry<String, LinkedList<String>> e = it.next();
			if (e.getKey().equals(e.getValue().getFirst()))
				continue;
			res++;
			sb.append(e.getValue().getFirst() + " " + e.getValue().getLast()
					+ "\n");
		}
		System.out.println(res);
		System.out.print(sb);
	}
}
