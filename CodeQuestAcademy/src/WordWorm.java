import java.util.*;
import java.io.*;
public class WordWorm {
	static int[] dX = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] dY = {1, -1, 0, 1, -1, 0, 1, -1};
	static char[][] grid;
	static int r, c;
	static boolean res;
	static String s;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			r = Integer.parseInt(sc.next());
			c = Integer.parseInt(sc.next());
			grid = new char[r][c];
			for(int j = 0; j < r; j++)
				for(int k = 0; k < c; k++)
					grid[j][k] = sc.next().charAt(0);
			int n = sc.nextInt();
			sc.nextLine();
			for(int j = 0; j < n; j++) {
				s = sc.nextLine();
				boolean didBreak = false;
				ArrayList<Integer> x = new ArrayList<Integer>();
				ArrayList<Integer> y = new ArrayList<Integer>();
				for(int k = 0; k < r; k++) {
					for(int l = 0; l < c; l++) {
						if(grid[k][l] == s.charAt(0)) {
							x.add(k);
							y.add(l);
						}
						if(s.length() == 1) {
							System.out.println(s);
							didBreak = true;
							break;
						}
					}
					if(didBreak)
						break;
				}
				if(didBreak)
					continue;
				for(int k = 0; k < x.size(); k++) {
					res = false;
					dfs(x.get(k), y.get(k), 1);
					if(res) {
						System.out.println(s);
						break;
					}
				}
			}
		}
		sc.close();
	}
	public static void dfs(int x, int y, int index) {
		for(int i = 0; i < 8; i++) {
			int dirX = dX[i];
			int dirY = dY[i];
			if(x + dX[i] < r && y + dY[i] < c && x + dX[i] >= 0 && y + dY[i] >= 0 && grid[x + dX[i]][y + dY[i]] == s.charAt(index)) {
				if(grid[x + dirX][y + dirY] == s.charAt(s.length() - 1) && index == s.length() - 1) {
					res = true;
					return;
				}
				dfs(x + dirX, y + dirY, index + 1);
			}
		}
	}
}