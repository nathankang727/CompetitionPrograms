package Jan2021Silver;
import java.util.*;
import java.io.*;
public class SpacedOut {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] grid = new int[n][n];
		int[][] cows = new int[n][n];
		int beauty = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				grid[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1; j++) {
				System.out.println("i: " + i + " j: " + j);
				int count = 0;
				if(cows[i][j] == 2)
					++count;
				if(cows[i + 1][j] == 2)
					++count;
				if(cows[i][j + 1] == 2)
					++count;
				if(cows[i + 1][j + 1] == 2)
					++count;
				int[] values = {grid[i][j], grid[i + 1][j], grid[i][j + 1], grid[i + 1][j + 1]};
				Arrays.sort(values);
				System.out.println(Arrays.toString(values));
				for(int k = 0; k < n; k++)
					System.out.println(Arrays.toString(cows[k]));
				System.out.println(count);
				if(count == 2) {
					if(cows[i][j] == 0)
						cows[i][j] = 1;
					if(cows[i + 1][j] == 0)
						cows[i + 1][j] = 1;
					if(cows[i + 1][j + 1] == 0)
						cows[i + 1][j + 1] = 1;
					if(cows[i][j + 1] == 0)
						cows[i][j + 1] = 1;
					continue;
				}
				else if(count == 1) {
					ArrayList<Integer> vals = new ArrayList<Integer>();
					if(cows[i][j] == 0)
						vals.add(grid[i][j]);
					if(cows[i + 1][j] == 0)
						vals.add(grid[i + 1][j]);
					if(cows[i + 1][j + 1] == 0)
						vals.add(grid[i + 1][j + 1]);
					if(cows[i][j + 1] == 0)
						vals.add(grid[i][j + 1]);
					Collections.sort(vals);
					int high = vals.get(vals.size() - 1);
					System.out.println(high);
					if(cows[i][j] == 0 && grid[i][j] == high) {
						++count;
						beauty += grid[i][j];
						cows[i][j] = 2;
					}
					else if(cows[i + 1][j] == 0 && grid[i + 1][j] == high) {
						++count;
						beauty += grid[i + 1][j];
						cows[i + 1][j] = 2;
					}
					else if(cows[i + 1][j + 1] == 0 && grid[i + 1][j + 1] == high) {
						++count;
						beauty += grid[i + 1][j + 1];
						cows[i + 1][j + 1] = 2;
					}
					else if(cows[i][j + 1] == 0 && grid[i][j + 1] == high) {
						++count;
						beauty += grid[i][j + 1];
						cows[i][j + 1] = 2;
					}
				}
				else if(count == 0) {
					System.out.println(grid[i][j] + " " + grid[i][j + 1] + " " + grid[i + 1][j] + " " + grid[i + 1][j + 1]);
					if(count < 2 && cows[i][j] == 0 && grid[i][j] == values[3] || grid[i][j] == values[2]) {
						++count;
						beauty += grid[i][j];
						cows[i][j] = 2;
					}
					if(count < 2 && cows[i + 1][j] == 0 && grid[i + 1][j] == values[3] || grid[i + 1][j] == values[2]) {
						++count;
						beauty += grid[i + 1][j];
						cows[i + 1][j] = 2;
					}
					if(count < 2 && cows[i + 1][j + 1] == 0 && grid[i + 1][j + 1] == values[3] || grid[i + 1][j + 1] == values[2]) {
						++count;
						beauty += grid[i + 1][j + 1];
						cows[i + 1][j + 1] = 2;
					}
					if(count < 2 && cows[i][j + 1] == 0 && grid[i][j + 1] == values[3] || grid[i][j + 1] == values[2]) {
						++count;
						beauty += grid[i][j + 1];
						cows[i][j + 1] = 2;
					}
				}
				if(cows[i][j] < 2)
					cows[i][j] = 1;
				if(cows[i][j + 1] < 2)
					cows[i][j + 1] = 1;
				if(cows[i + 1][j] < 2)
					cows[i + 1][j] = 1;
				if(cows[i + 1][j + 1] < 2)
					cows[i + 1][j + 1] = 1;
				System.out.println("beauty: " + beauty);
				System.out.println();
			}
		}
		System.out.println(beauty);
	}
}
/*
4
3 3 1 1
1 1 3 1
3 3 1 1
1 1 3 3
*/