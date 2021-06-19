package US_Open2017Silver;
import java.util.*;
import java.io.*;
public class where {
	static int n;
	static char c[][], grid[][];
	static ArrayList<int[]> list;
	static boolean v[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("where.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("where.out")));
		n = Integer.parseInt(br.readLine());
		c = new char[n][n];
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < n; j++)
				c[i][j] = input.charAt(j);
		}
		list = new ArrayList<int[]>();
		for(int r1 = 0; r1 < n; r1++) {
			for(int c1 = 0; c1 < n; c1++) {
				for(int r2 = n - 1; r2 >= r1; r2--) {
					for(int c2 = n - 1; c2 >= c1; c2--) {
						if(check(r1, c1, r2, c2)) {
							int[] n = {r1, c1, r2, c2};
							list.add(n);
						}
					}
				}
			}
		}
		pw.println(list.size());
		br.close();
		pw.close();
	}
	public static boolean check(int r1, int c1, int r2, int c2) {
		Set<Character> set = new HashSet<Character>();
		grid = new char[r2 - r1 + 1][c2 - c1 + 1];
		for(int i = r1; i <= r2; i++) {
			for(int j = c1; j <= c2; j++) {
				grid[i - r1][j - c1] = c[i][j];
				set.add(c[i][j]);
			}
		}
		if(set.size() != 2)
			return false;
		char[] arr = new char[2];
		int index = 0;
		for(char C : set)
			arr[index++] = C;
		int n1 = 0;
		int n2 = 0;
		v = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(!v[i][j] && grid[i][j] == arr[0]) {
					dfs(arr[0], i, j);
					++n1;
				}
			}
		}
		v = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(!v[i][j] && grid[i][j] == arr[1]) {
					dfs(arr[1], i, j);
					++n2;
				}
			}
		}
		if(!(n1 == 1 && n2 > 1 || n1 > 1 && n2 == 1))
			return false;
		for(int i = 0; i < list.size(); i++) {
			int[] arr2 = list.get(i);
			if(r1 >= arr2[0] && c1 >= arr2[1] && r2 <= arr2[2] && c2 <= arr2[3])
				return false;
		}
		return true;
	}
	public static void dfs(char ch, int x, int y) {
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != ch || v[x][y])
			return;
		v[x][y] = true;
		dfs(ch, x + 1, y);
		dfs(ch, x - 1, y);
		dfs(ch, x, y + 1);
		dfs(ch, x, y - 1);
	}
}