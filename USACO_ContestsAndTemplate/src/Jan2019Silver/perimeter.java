package Jan2019Silver;
import java.io.*;
public class perimeter {
	static int n, area, perimeter;
	static char[][] a;
	static boolean v[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("perimeter.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("perimeter.out")));
		n = Integer.parseInt(br.readLine());
		a = new char[n][n];
		v = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++)
				a[i][j] = s.charAt(j);
		}
		int maxArea = 0;
		int maxPerimeter = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!v[i][j]) {
					area = 0;
					perimeter = 0;
					floodfill(i, j);
					if(area == maxArea)
						maxPerimeter = Math.min(maxPerimeter, perimeter);
					else if(area > maxArea) {
						maxPerimeter = perimeter;
						maxArea = Math.max(maxArea, area);
					}
				}
			}
		}
		pw.println(maxArea + " " + maxPerimeter);
		br.close();
		pw.close();
	}
	public static void floodfill(int x, int y) {
		if(x < 0 || x >= n || y < 0 || y >= n) {
			++perimeter;
			return;
		}
		if(a[x][y] == '.') {
			++perimeter;
			return;
		}
		if(v[x][y])
			return;
		v[x][y] = true;
		++area;
		floodfill(x, y + 1);
		floodfill(x, y - 1);
		floodfill(x + 1, y);
		floodfill(x - 1, y);
	}
}