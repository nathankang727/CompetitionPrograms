import java.util.*;
import java.io.*;
public class moocrypt {
	static int n, m;
	static char grid[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		grid = new char[n][m];
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < m; j++)
				grid[i][j] = input.charAt(j);
		}
		int max = 0;
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < 26; j++) {
				if(i == j || i == 12 || j == 14)
					continue;
				char a = letters.charAt(i);
				char b = letters.charAt(j);
				max = Math.max(max, horizontal(a, b) + vertical(a, b) + diagonal1(a, b) + diagonal2(a, b));
			}
		}
		System.out.println(max);
		br.close();
	}
	public static int horizontal(char a, char b) {
		int res = 0;
		String s1 = a + "" + b + "" + b;
		String s2 = b + "" + b + "" + a;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m - 2; j++) {
				String s3 = grid[i][j] + "" + grid[i][j + 1] + "" + grid[i][j + 2];
				if(s3.equals(s1) || s3.equals(s2))
					++res;
			}
		}
		return res;
	}
	public static int vertical(char a, char b) {
		int res = 0;
		String s1 = a + "" + b + "" + b;
		String s2 = b + "" + b + "" + a;
		for(int i = 0; i < n - 2; i++) {
			for(int j = 0; j < m; j++) {
				String s3 = grid[i][j] + "" + grid[i + 1][j] + "" + grid[i + 2][j];
				if(s3.equals(s1) || s3.equals(s2))
					++res;
			}
		}
		return res;
	}
	public static int diagonal1(char a, char b) {
		int res = 0;
		String s1 = a + "" + b + "" + b;
		String s2 = b + "" + b + "" + a;
		for(int i = 0; i < n - 2; i++) {
			for(int j = 0; j < m - 2; j++) {
				String s3 = grid[i][j] + "" + grid[i + 1][j + 1] + "" + grid[i + 2][j + 2];
				if(s3.equals(s1) || s3.equals(s2))
					++res;
			}
		}
		return res;
	}
	public static int diagonal2(char a, char b) {
		int res = 0;
		String s1 = a + "" + b + "" + b;
		String s2 = b + "" + b + "" + a;
		for(int i = 0; i < n - 2; i++) {
			for(int j = 0; j < m - 2; j++) {
				String s3 = grid[i][j + 2] + "" + grid[i + 1][j + 1] + "" + grid[i + 2][j];
				if(s3.equals(s1) || s3.equals(s2))
					++res;
			}
		}
		return res;
	}
}