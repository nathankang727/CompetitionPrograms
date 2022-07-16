import java.util.*;
import java.io.*;
public class numgrid {
	static int grid[][], cnt;
	static Set<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[5][5];
		set = new HashSet<Integer>();
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++)
				grid[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				dfs(0, i, j, 0);
		System.out.println(set.size());
		br.close();
	}
	public static void dfs(int c, int x, int y, int temp) {
		if(x < 0 || x > 4 || y < 0 || y > 4)
			return;
		temp += grid[x][y] * Math.pow(10, c);
		if(c == 5) {
			set.add(temp);
			return;
		}
		dfs(c + 1, x + 1, y, temp);
		dfs(c + 1, x - 1, y, temp);
		dfs(c + 1, x, y + 1, temp);
		dfs(c + 1, x, y - 1, temp);
	}
}