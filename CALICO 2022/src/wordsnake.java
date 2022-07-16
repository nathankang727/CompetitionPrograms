import java.util.*;
public class wordsnake {
	static int[] dX = {0, 0, 1, -1};
	static int[] dY = {1, -1, 0, 0};
	static char[][] grid;
	static int r, c;
	static String s;
	static ArrayList<Integer> x;
	static ArrayList<Integer> y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			s = sc.nextLine();
			r = sc.nextInt();
			c = sc.nextInt();
			sc.nextLine();
			grid = new char[r][c];
			for(int j = 0; j < r; j++) {
				String input = sc.nextLine();
				for(int k = 0; k < c; k++)
					grid[j][k] = input.charAt(k);
			}
			if(i < t - 1)
				sc.nextLine();
			ArrayList<Integer> xx = new ArrayList<Integer>();
			ArrayList<Integer> yy = new ArrayList<Integer>();
			boolean didBreak = false;
			for(int j = 0; j < r; j++) {
				for(int k = 0; k < c; k++) {
					if(grid[j][k] == s.charAt(0)) {
						xx.add(j);
						yy.add(k);
					}
					if(s.length() == 1 && grid[j][k] == s.charAt(0)) {
						for(int a = 0; a < r; a++) {
							for(int b = 0; b < c; b++) {
								if(a == j && b == k)
									System.out.print(grid[j][k]);
								else
									System.out.print("#");
							}
							System.out.println();
						}
						didBreak = true;
						break;
					}
				}
				if(didBreak)
					break;
			}
			if(didBreak)
				continue;
			for(int j = 0; j < xx.size(); j++) {
				for(int k = 0; k < 25; k++) {
					x = new ArrayList<Integer>();
					y = new ArrayList<Integer>();
					x.add(xx.get(j));
					y.add(yy.get(j));
					dfs(xx.get(j), yy.get(j), 1);
				}
			}
			for(int a = 0; a < r; a++) {
				for(int b = 0; b < c; b++)
					System.out.print(grid[a][b]);
				System.out.println();
			}
			if(i < t - 1)
				System.out.println();
		}
		sc.close();
	}
	public static void dfs(int xx, int yy, int index) {
		boolean works = false;
		for(int i = 0; i < 4; i++) {
			int dirX = dX[i];
			int dirY = dY[i];
			if(xx + dX[i] < r && yy + dY[i] < c && xx + dX[i] >= 0 && yy + dY[i] >= 0 && grid[xx + dX[i]][yy + dY[i]] == s.charAt(index)) {
				x.add(xx + dX[i]);
				y.add(yy + dY[i]);
				works = true;
				if(grid[xx + dirX][yy + dirY] == s.charAt(s.length() - 1) && index == s.length() - 1) {
					char[][] temp = new char[r][c];
					for(int j = 0; j < r; j++) {
						for(int k = 0; k < c; k++) {
							boolean didBreak = false;
							for(int l = 0; l < x.size(); l++) {
								if(j == x.get(l) && k == y.get(l)) {
									temp[j][k] = grid[j][k];
									didBreak = true;
									break;
								}
							}
							if(!didBreak)
								temp[j][k] = '#';
						}
					}
					for(int j = 0; j < r; j++)
						for(int k = 0; k < c; k++)
							grid[j][k] = temp[j][k];
					return;
				}
				dfs(xx + dirX, yy + dirY, index + 1);
			}	
		}
		if(!works) {
			x.remove(x.size() - 1);
			y.remove(y.size() - 1);
		}
	}
}