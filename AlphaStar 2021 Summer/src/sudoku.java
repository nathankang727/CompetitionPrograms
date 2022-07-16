import java.util.*;
import java.io.*;
public class sudoku {
	static int grid[][];
	static boolean found;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[9][9];
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++)
				grid[i][j] = Integer.parseInt(st.nextToken());
		}
		found = false;
		dfs(0, 0);
		if(!found)
			System.out.println("NO SOLUTION");
		br.close();
	}
	public static void dfs(int x, int y) {
		if(found)
			return;
		if(x == 9) {
			found = true;
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 8; j++)
					System.out.print(grid[i][j] + " ");
				System.out.print(grid[i][8] + "\n");
			}
			return;
		}
		if(grid[x][y] == 0) {
			for(int i = 1; i <= 9; i++) {
				grid[x][y] = i;
				if(check(x, y)) {
					if(y + 1 < 9)
						dfs(x, y + 1);
					else
						dfs(x + 1, 0);
				}
				grid[x][y] = 0;
			}
		}
		else {
			if(y + 1 < 9)
				dfs(x, y + 1);
			else
				dfs(x + 1, 0);
		}
	}
	public static boolean check(int x, int y) {
		int temp = grid[x][y];
		for(int i = 0; i < 9; i++)
			if(i != x && grid[i][y] == temp || i != y && grid[x][i] == temp)
				return false;
		if(x >= 0 && x <= 2 && y >= 0 && y <= 2) {
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 3; j++)
					if(i != x && j != y && grid[i][j] == temp)
						return false;
		}
		else if(x >= 0 && x <= 2 && y >= 3 && y <= 5) {
			for(int i = 0; i < 3; i++)
				for(int j = 3; j < 6; j++)
					if(i != x && j != y && grid[i][j] == temp)
						return false;
		}
		else if(x >= 0 && x <= 2 && y >= 6 && y <= 8) {
			for(int i = 0; i < 3; i++)
				for(int j = 6; j < 9; j++)
					if(i != x && j != y && grid[i][j] == temp)
						return false;
		}
		else if(x >= 3 && x <= 5 && y >= 0 && y <= 2) {
			for(int i = 3; i < 6; i++)
				for(int j = 0; j < 3; j++)
					if(i != x && j != y && grid[i][j] == temp)
						return false;
		}
		else if(x >= 3 && x <= 5 && y >= 3 && y <= 5) {
			for(int i = 3; i < 6; i++)
				for(int j = 3; j < 6; j++)
					if(i != x && j != y && grid[i][j] == temp)
						return false;
		}
		else if(x >= 3 && x <= 5 && y >= 6 && y <= 8) {
			for(int i = 3; i < 6; i++)
				for(int j = 6; j < 9; j++)
					if(i != x && j != y && grid[i][j] == temp)
						return false;
		}
		else if(x >= 6 && x <= 8 && y >= 0 && y <= 2) {
			for(int i = 6; i < 9; i++)
				for(int j = 0; j < 3; j++)
					if(i != x && j != y && grid[i][j] == temp)
						return false;
		}
		else if(x >= 6 && x <= 8 && y >= 3 && y <= 5) {
			for(int i = 6; i < 9; i++)
				for(int j = 3; j < 6; j++)
					if(i != x && j != y && grid[i][j] == temp)
						return false;
		}
		else {
			for(int i = 6; i < 9; i++)
				for(int j = 6; j < 9; j++)
					if(i != x && j != y && grid[i][j] == temp)
						return false;
		}
		return true;
	}
}