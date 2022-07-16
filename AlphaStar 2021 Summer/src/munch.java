import java.util.*;
import java.io.*;
public class munch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] grid = new char[r][c];
		int startX = 0;
		int startY = 0;
		int endX = 0;
		int endY = 0;
		for(int i = 0; i < r; i++) {
			String input = br.readLine();
			for(int j = 0; j < c; j++) {
				grid[i][j] = input.charAt(j);
				if(grid[i][j] == 'C') {
					startX = i;
					startY = j;
					grid[i][j] = '.';
				}
				else if(grid[i][j] == 'B') {
					endX = i;
					endY = j;
					grid[i][j] = '.';
				}
			}
		}
		int[] rowD = {-1, 1, 0, 0};
		int[] colD = {0, 0, -1, 1};
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startX);
		q.add(startY);
		q.add(0);
		grid[startX][startY] = '*';
		while(!q.isEmpty()) {
			int row = q.remove();
			int col = q.remove();
			int cnt = q.remove();
			if(row == endX && col == endY) {
				System.out.println(cnt);
				break;
			}
			for(int k = 0; k < 4; k++) {
				int row2 = row + rowD[k];
				int col2 = col + colD[k];
				if(row2 < 0 || row2 >= r || col2 < 0 || col2 >= c)
					continue;
				if(grid[row2][col2] == '.') {
					grid[row2][col2] = '*';
					q.add(row2);
					q.add(col2);
					q.add(cnt + 1);
				}
			}
		}
		br.close();
	}
}