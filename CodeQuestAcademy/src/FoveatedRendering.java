import java.util.*;
public class FoveatedRendering {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int[][] grid = new int[20][20];
			for(int j = 0; j < 20; j++)
				Arrays.fill(grid[j], 10);
			int x = sc.nextInt();
			int y = sc.nextInt();
			grid[x][y] = 100;
			if(x < 19)
				grid[x + 1][y] = 50;
			if(x > 0)
				grid[x - 1][y] = 50;
			if(y < 19)
				grid[x][y + 1] = 50;
			if(y > 0)
				grid[x][y - 1] = 50;
			if(x < 19 && y < 19)
				grid[x + 1][y + 1] = 50;
			if(x < 19 && y > 0)
				grid[x + 1][y - 1] = 50;
			if(x > 0 && y < 19)
				grid[x - 1][y + 1] = 50;
			if(x > 0 && y > 0)
				grid[x - 1][y - 1] = 50;
			for(int j = 0; j < 20; j++) {
				for(int k = 0; k < 20; k++) {
					if(grid[j][k] == 50) {
						if(j < 19)
							grid[j + 1][k] = Math.max(grid[j + 1][k], 25);
						if(j > 0)
							grid[j - 1][k] = Math.max(grid[j - 1][k], 25);
						if(k < 19)
							grid[j][k + 1] = Math.max(grid[j][k + 1], 25);
						if(k > 0)
							grid[j][k - 1] = Math.max(grid[j][k - 1], 25);
						if(j < 19 && k < 19)
							grid[j + 1][k + 1] = Math.max(grid[j + 1][k + 1], 25);
						if(j < 19 && k > 0)
							grid[j + 1][k - 1] = Math.max(grid[j + 1][k - 1], 25);
						if(j > 0 && k < 19)
							grid[j - 1][k + 1] = Math.max(grid[j - 1][k + 1], 25);
						if(j > 0 && k > 0)
							grid[j - 1][k - 1] = Math.max(grid[j - 1][k - 1], 25);
					}
				}
			}
			for(int j = 0; j < 20; j++) {
				String ans = grid[j][0] + "";
				for(int k = 1; k < 20; k++)
					ans += " " + grid[j][k];
				System.out.println(ans);
			}
		}
		sc.close();
	}
}