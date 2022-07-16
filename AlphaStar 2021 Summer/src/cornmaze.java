import java.util.*;
import java.io.*;
public class cornmaze {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int startX = 0;
		int startY = 0;
		int endX = 0;
		int endY = 0;
		char[][] maze = new char[n][m];
		ArrayList<Wormhole> worm = new ArrayList<Wormhole>();
		for(int i = 0; i < n; i++)  {
			String input = br.readLine();
			for(int j = 0; j < m; j++) {
				if(input.charAt(j) == '@') {
					maze[i][j] = '.';
					startX = i;
					startY = j;
				}
				else if(input.charAt(j) == '=') {
					maze[i][j] = '.';
					endX = i;
					endY = j;
				}
				else if(input.charAt(j) != '.' && input.charAt(j) != '#') {
					maze[i][j] = input.charAt(j);
					worm.add(new Wormhole(input.charAt(j), i, j));
				}
				else
					maze[i][j] = input.charAt(j);
			}
		}
		int[] rowD = {-1, 0, 1, 0};
		int[] colD = {0, 1, 0, -1};
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startX);
		q.add(startY);
		q.add(0);
		maze[startX][startY] = '#';
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
				if(row2 < 0 || row2 >= n || col2 < 0 || col2 >= m)
					continue;
				if(maze[row2][col2] == '.') {
					maze[row2][col2] = '#';
					q.add(row2);
					q.add(col2);
					q.add(cnt + 1);
				}
				else if(maze[row2][col2] != '#') {
					for(int i = 0; i < worm.size(); i++) {
						if(worm.get(i).c == maze[row2][col2] && !(worm.get(i).x == row2 && worm.get(i).y == col2)) {
							q.add(worm.get(i).x);
							q.add(worm.get(i).y);
							q.add(cnt + 1);
							break;
						}
					}
				}
			}
		}
		br.close();
	}
	static class Wormhole {
		public char c;
		public int x, y;
		public Wormhole(char wormhole, int xx, int yy) {
			this.c = wormhole;
			this.x = xx;
			this.y = yy;
		}
	}
}