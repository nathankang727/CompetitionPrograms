import java.util.*;
import java.io.*;
public class gates {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		boolean[][] grid = new boolean[2005][2005];
		int r = 1002;
		int c = 1002;
		grid[r][c] = true;
		for(int i = 0; i < n; i++) {
			for(int a = 0; a < 2; a++) {
				if(s.charAt(i) == 'N')
					--r;
				else if(s.charAt(i) == 'S')
					++r;
				else if(s.charAt(i) == 'E')
					++c;
				else
					--c;
				grid[r][c] = true;
			}
		}
		int ans = 0;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int i = 0; i < 2005; i++) {
			for(int j = 0; j < 2005; j++) {
				if(grid[i][j])
					continue;
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(i);
				q.add(j);
				grid[i][j] = true;
				while(!q.isEmpty()) {
					int currX = q.remove();
					int currY = q.remove();
					for(int k = 0; k < 4; k++) {
						int newX = currX + dx[k];
						int newY = currY + dy[k];
						if(newX >= 0 && newX < 2005 && newY >= 0 && newY < 2005 && !grid[newX][newY]) {
							grid[newX][newY] = true;
							q.add(newX);
							q.add(newY);
						}
					}
				}
				++ans;
			}
		}
		System.out.println(ans - 1);
		br.close();
	}
}