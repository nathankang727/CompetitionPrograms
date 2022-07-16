import java.util.*;
import java.io.*;
public class palpath {
	static int n;
	static char grid[][];
	static HashMap<ArrayList<Character>, Integer>[] map1;
	static HashMap<ArrayList<Character>, Integer>[] map2;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		grid = new char[n][n];
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < n; j++)
				grid[i][j] = input.charAt(j);
		}
		map1 = new HashMap[n];
		for(int i = 0; i < n; i++) {
			map1[i] = new HashMap<ArrayList<Character>, Integer>();
			dfs1(0, 0, i, n - i - 1, 0, new char[n - 1]);
		}
		map2 = new HashMap[n];
		for(int i = 0; i < n; i++) {
			map2[i] = new HashMap<ArrayList<Character>, Integer>();
			dfs2(n - 1, n - 1, i, n - i - 1, 0, new char[n - 1]);
		}
		HashSet<ArrayList<Character>> set = new HashSet<ArrayList<Character>>();
		for(int i = 0; i < n; i++) {
			for(Map.Entry<ArrayList<Character>, Integer> map : map1[i].entrySet()) {
				if(map2[i].containsKey(map.getKey())) {
					ArrayList<Character> temp = new ArrayList<Character>();
					for(int j = 0; j < map.getKey().size(); j++)
						temp.add(map.getKey().get(j));
					set.add(temp);
				}
			}
		}
		System.out.println(set.size());
		br.close();
	}
	public static void dfs1(int startX, int startY, int endX, int endY, int index, char[] c) {
		if(startX >= n || startY >= n)
			return;
		else if(startX == endX && startY == endY) {
			ArrayList<Character> temp = new ArrayList<Character>();
			for(int i = 0; i < c.length; i++)
				temp.add(c[i]);
			temp.add(grid[startX][startY]);
			map1[endX].put(temp, 0);
			return;
		}
		if(index == n - 1)
			return;
		c[index] = grid[startX][startY];
		dfs1(startX + 1, startY, endX, endY, index + 1, c);
		dfs1(startX, startY + 1, endX, endY, index + 1, c);
	}
	public static void dfs2(int startX, int startY, int endX, int endY, int index, char[] c) {
		if(startX < 0 || startY < 0)
			return;
		else if(startX == endX && startY == endY) {
			ArrayList<Character> temp = new ArrayList<Character>();
			for(int i = 0; i < c.length; i++)
				temp.add(c[i]);
			temp.add(grid[startX][startY]);
			map2[endX].put(temp, 0);
			return;
		}
		if(index == n - 1)
			return;
		c[index] = grid[startX][startY];
		dfs2(startX - 1, startY, endX, endY, index + 1, c);
		dfs2(startX, startY - 1, endX, endY, index + 1, c);
	}
}