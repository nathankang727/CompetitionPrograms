import java.util.*;
import java.io.*;
public class wmorph {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String start = sc.nextLine();
		String end = sc.nextLine();
		int len = start.length();
		Set<String> dictionary = new HashSet<String>();
		Map<String, Boolean> visited = new HashMap<String, Boolean>();
		while(sc.hasNextLine()) {
			String input = sc.nextLine();
			if(input.length() == len) {
				dictionary.add(input);
				visited.put(input, false);
			}
		}
		dictionary.add(start);
		dictionary.add(end);
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(String s : dictionary) {
			map.put(s, new ArrayList<String>());
			for(String s2 : dictionary) {
				if(s.equals(s2))
					continue;
				int diff = 0;
				for(int i = 0; i < len; i++)
					if(s.charAt(i) != s2.charAt(i))
						++diff;
				if(diff == 1)
					map.get(s).add(s2);
			}
		}
		Queue<Vertex> q = new LinkedList<Vertex>();
		visited.put(start, true);
		q.add(new Vertex(start, 0));
		while(!q.isEmpty()) {
			Vertex v = q.remove();
			String temp = v.s;
			int cnt = v.c;
			if(temp.equals(end)) {
				System.out.println(cnt);
				break;
			}
			for(int i = 0; i < map.get(temp).size(); i++) {
				if(visited.get(map.get(temp).get(i)))
					continue;
				q.add(new Vertex(map.get(temp).get(i), cnt + 1));
				visited.put(map.get(temp).get(i), true);
			}
		}
		sc.close();
	}
	static class Vertex {
		public String s;
		public int c;
		public Vertex(String vertex, int count) {
			this.s = vertex;
			this.c = count;
		}
	}
}