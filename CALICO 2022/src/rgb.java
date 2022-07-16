import java.util.*;
public class rgb {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String[] input = sc.nextLine().split("x");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			char[][] grid = new char[r][c];
			for(int j = 0; j < r; j += 2) {
				for(int k = 0; k < c; k += 2)
					grid[j][k] = 'B';
				for(int k = 1; k < c; k += 2)
					grid[j][k] = 'G';
			}
			for(int j = 1; j < r; j += 2) {
				for(int k = 0; k < c; k += 2)
					grid[j][k] = 'G';
				for(int k = 1; k < c; k += 2)
					grid[j][k] = 'R';
			}
			for(int j = 0; j < r; j++) {
				for(int k = 0; k < c; k++)
					System.out.print(grid[j][k] + "");
				System.out.println();
			}
			System.out.println();
		}
		sc.close();
	}
}