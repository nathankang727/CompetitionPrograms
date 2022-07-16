import java.util.*;
import java.io.*;
public class space2 {
	public static void main(String[] args) throws IOException {
		bfs();
	}
	private static void bfs() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] grid = new int[n][n];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++)
				grid[i][j] = s.charAt(j) == '.' ? 0 : -1;
		}
		int[] rowD = {-1, 0, 1, 0};
		int[] colD = {0, 1, 0, -1};
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == -1) {
					++cnt;
					q.add(i);
					q.add(j);
					grid[i][j] = cnt;
					while(!q.isEmpty()) {
						int row = q.remove();
						int col = q.remove();
						for(int k = 0; k < 4; k++) {
							int row2 = row + rowD[k];
							int col2 = col + colD[k];
							if(row2 < 0 || row2 >= n || col2 < 0 || col2 >= n)
								continue;
							if(grid[row2][col2] == -1) {
								grid[row2][col2] = cnt;
								q.add(row2);
								q.add(col2);
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
		br.close();
	}
}