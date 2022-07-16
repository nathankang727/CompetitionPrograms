import java.util.*;
import java.io.*;
public class lphones {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		char[][] grid = new char[h][w];
		int startRow = 0;
		int startCol = 0;
		int endRow = 0;
		int endCol = 0;
		boolean firstCow = true;
		for(int i = 0; i < h; i++) {
			String input = br.readLine();
			for(int j = 0; j < w; j++) {
				if(input.charAt(j) == 'C' && firstCow) {
					startRow = i;
					startCol = j;
					grid[i][j] = '.';
					firstCow = false;
				}
				else if(input.charAt(j) == 'C' && !firstCow) {
					endRow = i;
					endCol = j;
					grid[i][j] = '.';
				}
				else
					grid[i][j] = input.charAt(j);
			}
		}
		int[][][] sol = new int[h][w][4];
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				for(int k = 0; k < 4; k++)
					sol[i][j][k] = Integer.MAX_VALUE;
		int[] rowD = {-1, 0, 1, 0};
		int[] colD = {0, 1, 0, -1};
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < 4; i++) {
			sol[startRow][startCol][i] = 0;
			q.add(startRow);
			q.add(startCol);
			q.add(i);
		}
		while(!q.isEmpty()) {
			int row = q.remove();
			int col = q.remove();
			int dir = q.remove();
			for(int i = 0; i < 4; i++) {
				int row2 = row + rowD[i];
				int col2 = col + colD[i];
				if(row2 < 0 || row2 >= h || col2 < 0 || col2 >= w)
					continue;
				if(grid[row2][col2] == '*')
					continue;
				for(int j = 0; j < 4; j++) {
					if(i == dir && j == dir && sol[row2][col2][dir] > sol[row][col][dir]) {
						sol[row2][col2][dir] = sol[row][col][dir];
						q.add(row2);
						q.add(col2);
						q.add(dir);
					}
					else if(i == dir && j != dir && sol[row2][col2][j] > sol[row][col][dir] + 1) {
						sol[row2][col2][j] = sol[row][col][dir] + 1;
						q.add(row2);
						q.add(col2);
						q.add(j);
						
					}
				}
			}
		}
		int ans = Math.min(sol[endRow][endCol][0], sol[endRow][endCol][1]);
		ans = Math.min(ans, Math.min(sol[endRow][endCol][2], sol[endRow][endCol][3]));
		System.out.println(ans);
		br.close();
	}
}