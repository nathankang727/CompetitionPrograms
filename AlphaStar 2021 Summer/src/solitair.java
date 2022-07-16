import java.util.*;
import java.io.*;
public class solitair {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] grid = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				String input = st.nextToken().substring(0, 1).replace("A", "1").replace("T", "10");
				input = input.replace("J", "11").replace("Q", "12").replace("K", "13");
				grid[i][j] = Integer.parseInt(input);
			}
		}
		int[] dRow = {0, -1};
		int[] dCol = {1, 0};
		Queue<Integer> q = new LinkedList<Integer>();
		int max = 0;
		q.add(n - 1);
		q.add(0);
		q.add(grid[n - 1][0]);
		while(!q.isEmpty()) {
			int row = q.remove();
			int col = q.remove();
			int cnt = q.remove();
			if(row == 0 && col == n - 1) {
				max = Math.max(max, cnt);
				continue;
			}
			for(int i = 0; i < 2; i++) {
				int row2 = row + dRow[i];
				int col2 = col + dCol[i];
				if(row2 < 0 || col2 >= n)
					continue;
				q.add(row2);
				q.add(col2);
				q.add(cnt + grid[row2][col2]);
			}
		}
		System.out.println(max);
		br.close();
	}
}