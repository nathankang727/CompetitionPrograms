import java.util.*;
import java.io.*;
public class space3d {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][][] grid = new char[n][n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				String input = br.readLine();
				for(int k = 0; k < n; k++)
					grid[i][j][k] = input.charAt(k);
			}
		}
		int[] xD = {-1, 1, 0, 0, 0, 0};
		int[] yD = {0, 0, -1, 1, 0, 0};
		int[] zD = {0, 0, 0, 0, -1, 1};
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(grid[i][j][k] == '*') {
						++cnt;
						q.add(i);
						q.add(j);
						q.add(k);
						grid[i][j][k] = '.';
						while(!q.isEmpty()) {
							int x = q.remove();
							int y = q.remove();
							int z = q.remove();
							for(int l = 0; l < 6; l++) {
								int x2 = x + xD[l];
								int y2 = y + yD[l];
								int z2 = z + zD[l];
								if(x2 < 0 || x2 >= n || y2 < 0 || y2 >= n || z2 < 0 || z2 >= n)
									continue;
								if(grid[x2][y2][z2] == '*') {
									grid[x2][y2][z2] = '.';
									q.add(x2);
									q.add(y2);
									q.add(z2);
								}
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