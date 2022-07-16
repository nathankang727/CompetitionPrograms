import java.util.*;
import java.io.*;
public class bronlily {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m1 = Integer.parseInt(st.nextToken());
		int m2 = Integer.parseInt(st.nextToken());
		int[][] grid = new int[m][n];
		int startX = 0;
		int endX = 0;
		int startY = 0;
		int endY = 0;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 0 || temp == 2)
					grid[i][j] = 0;
				else if(temp == 3) {
					startX = i;
					startY = j;
					grid[i][j] = 1;
				}
				else if(temp == 4) {
					endX = i;
					endY = j;
					grid[i][j] = 1;
				}
				else
					grid[i][j] = 1;
			}
		}
		int[] rowD = {m1, m2, -m1, -m2, m1, m2, -m1, -m2};
		int[] colD = {m2, m1, -m2, -m1, -m2, -m1, m2, m1};
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startX);
		q.add(startY);
		q.add(0);
		grid[startX][startY] = 0;
		while(!q.isEmpty()) {
			int row = q.remove();
			int col = q.remove();
			int cnt = q.remove();
			if(row == endX && col == endY) {
				System.out.println(cnt);
				break;
			}
			for(int k = 0; k < 8; k++) {
				int row2 = row + rowD[k];
				int col2 = col + colD[k];
				if(row2 < 0 || row2 >= m || col2 < 0 || col2 >= n)
					continue;
				if(grid[row2][col2] == 1) {
					grid[row2][col2] = 0;
					q.add(row2);
					q.add(col2);
					q.add(cnt + 1);
				}
			}
		}
		br.close();
	}
}