package Feb2021Silver;
import java.util.*;
import java.io.*;
public class JustGreenEnough {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] grid = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				grid[i][j] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] < 100)
					grid[i][j] = 0;
				else if(grid[i][j] == 100) {
					list.add(i);
					list.add(j);
				}
				else
					grid[i][j] = 1;
			}
		}
		
		br.close();
	}
}
/*
3
57 120 87
200 100 150
2 141 135

8
*/