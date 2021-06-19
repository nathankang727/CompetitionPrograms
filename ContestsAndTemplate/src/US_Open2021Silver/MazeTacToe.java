package US_Open2021Silver;
import java.util.*;
import java.io.*;
public class MazeTacToe {
	static int n, maxCom;
	static String maze[][];
	static Set<char[][]> ans = new HashSet<char[][]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maze = new String[n][n];
		maxCom = 0;
		int bessieX = 0;
		int bessieY = 0;
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < input.length(); j += 3) {
				if(input.substring(j, j + 3).equals("BBB")) {
					bessieX = i;
					bessieY = j / 3;
				}
				else if(input.charAt(j) == 'O' || input.charAt(j) == 'M')
					++maxCom;
				maze[i][j / 3] = input.substring(j, j + 3);
			}
		}
		boolean[][] visited = new boolean[n][n];
		Set<String> commandSet = new HashSet<String>();
		char[][] ticTacToe = {{'.', '.', '.', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}};
		findPaths(bessieX, bessieY, visited, commandSet, ticTacToe);
		System.out.println(ans.size());
		br.close();
	}
	public static void findPaths(int xx, int yy, boolean[][] vv, Set<String> sset, char[][] ggrid) {
		Queue<qClass> q = new LinkedList<qClass>();
		vv[xx][yy] = true;
		q.add(new qClass(xx, yy, sset, vv, ggrid));
		int[] rDirect = {-1, 1, 0, 0};
		int[] cDirect = {0, 0, -1, 1};
		while(!q.isEmpty()) {
			qClass temp = q.poll();
			if(temp.grid[1][1] == 'M' && temp.grid[1][2] == 'O' && temp.grid[1][3] == 'O' || temp.grid[1][1] == 'O' && temp.grid[1][2] == 'O'
					&& temp.grid[1][3] == 'M' || temp.grid[2][1] == 'M' && temp.grid[2][2] == 'O' && temp.grid[2][3] == 'O' || 
					temp.grid[2][1] == 'O' && temp.grid[2][2] == 'O' && temp.grid[2][3] == 'M' || temp.grid[3][1] == 'M' && 
					temp.grid[3][2] == 'O' && temp.grid[3][3] == 'O' || temp.grid[3][1] == 'O' && temp.grid[3][2] == 'O' && 
					temp.grid[3][3] == 'M' || temp.grid[1][1] == 'M' && temp.grid[2][1] == 'O' && temp.grid[3][1] == 'O' || 
					temp.grid[1][1] == 'O' && temp.grid[2][1] == 'O' && temp.grid[3][1] == 'M' || temp.grid[1][2] == 'M' && 
					temp.grid[2][2] == 'O' && temp.grid[3][2] == 'O' || temp.grid[1][2] == 'O' && temp.grid[2][2] == 'O' && 
					temp.grid[3][2] == 'M' || temp.grid[1][3] == 'M' && temp.grid[2][3] == 'O' && temp.grid[3][3] == 'O' || 
					temp.grid[1][3] == 'O' && temp.grid[2][3] == 'O' && temp.grid[3][3] == 'M' || temp.grid[1][1] == 'M' && 
					temp.grid[2][2] == 'O' && temp.grid[3][3] == 'O' || temp.grid[1][1] == 'O' && temp.grid[2][2] == 'O' && 
					temp.grid[3][3] == 'M' || temp.grid[1][3] == 'M' && temp.grid[2][2] == 'O' && temp.grid[3][1] == 'O' || 
					temp.grid[1][3] == 'O' && temp.grid[2][2] == 'O' && temp.grid[3][1] == 'M') {
				ans.add(temp.grid);
				continue;
			}
			for(int i = 0; i < 4; i++) {
				int row = temp.x + rDirect[i];
				int col = temp.y + cDirect[i];
				if(row < 0 || col < 0 || row >= n || col >= n || temp.v[row][col] || maze[row][col].equals("###") || temp.set.size() == maxCom)
					continue;
				if(maze[row][col].charAt(0) == 'M') {
					if(!temp.set.contains(maze[row][col])) {
						temp.v = new boolean[n][n];
						temp.v[row][col] = true;
					}
					temp.set.add(maze[row][col]);
					int n1 = Integer.parseInt(maze[row][col].substring(1, 2));
					int n2 = Integer.parseInt(maze[row][col].substring(2));
					if(temp.grid[n1][n2] == '.') {
						
					}
				}
			}
		}
	}
	static class qClass {
		public int x, y;
		public Set<String> set;
		public boolean[][] v;
		public char[][] grid;
		public qClass(int xx, int yy, Set<String> setset, boolean[][] vv, char[][] gridgrid) {
			this.x = xx;
			this.y = yy;
			this.set = setset;
			this.v = vv;
			this.grid = gridgrid;
		}
	}
}