import java.util.*;
import java.io.*;
public class hexagon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[][] grid = new int[4 * k - 3][2 * k - 1];
		int val = 1;
		int index = 1;
		int startRow = 0;
		int startCol = 0;
		for(int j = 0; j < k; j++) {
			for(int i = 3 * k + j - 3; i >= k - index - 1; i -= 2) {
				grid[i][j] = val;
				if(val == h) {
					startRow = i;
					startCol = j;
				}
				++val;
			}
			++index;
		}
		index = 1;
		for(int j = k; j < 2 * k - 1; j++) {
			for(int i = 4 * k - 4 - index; i >= index; i -= 2) {
				grid[i][j] = val;
				if(val == h) {
					startRow = i;
					startCol = j;
				}
				++val;
			}
			++index;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		boolean[] visited = new boolean[val];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[h] = true;
		q.add(startRow);
		q.add(startCol);
		q.add(0);
		int[] dRow = {2, -2, 1, -1, 1, -1};
		int[] dCol = {0, 0, -1, -1, 1, 1};
		while(!q.isEmpty()) {
			int r = q.remove();
			int c = q.remove();
			int count = q.remove();
			if(count == l) {
				set.add(grid[r][c]);
				continue;
			}
			for(int i = 0; i < 6; i++) {
				int r2 = r + dRow[i];
				int c2 = c + dCol[i];
				if(r2 < 0 || r2 > 4 * k - 4 || c2 < 0 || c2 > 2 * k - 2 || grid[r2][c2] == 0)
					continue;
				if(!visited[grid[r2][c2]]) {
					visited[grid[r2][c2]] = true;
					q.add(r2);
					q.add(c2);
					q.add(count + 1);
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : set)
			list.add(i);
		Collections.sort(list);
		System.out.println(list.size());
		for(int i : list)
			System.out.println(i);
		br.close();
	}
}