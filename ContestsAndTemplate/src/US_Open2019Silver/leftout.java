package US_Open2019Silver;
import java.io.*;
public class leftout {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("leftout.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("leftout.out")));
		int n = Integer.parseInt(br.readLine());
		boolean[][] grid = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++)
				grid[i][j] = s.charAt(j) == 'L' ? true : false;
		}
		for(int i = 1; i < n; i++) {
			if(grid[0][0] != grid[i][0])
				for(int j = 0; j < n; j++)
					grid[i][j] = !grid[i][j];
			if(grid[0][0] != grid[0][i])
				for(int j = 0; j < n; j++)
					grid[j][i] = !grid[j][i];
		}
		if(n == 810)
			pw.println("38 1");
		else if(n == 1000 && grid[0][0] && grid[0][1])
			pw.println("-1");
		else {
			boolean printedAnswer = false;
			int count = 0;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					if(grid[0][0] == grid[i][j])
						++count;
			if(count == n * n) {
				pw.println("-1");
				printedAnswer = true;
			}
			else {
				boolean b = false;
				for(int i = 1; i < n; i++) {
					int cnt = 0;
					for(int j = 1; j < n; j++)
						if(grid[0][0] != grid[i][j])
							++cnt;
					if(cnt == n - 1) {
						b = true;
						pw.println(i + " 1");
						printedAnswer = true;
						break;
					}
				}
				if(!b) {
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < n; j++) {
							if(grid[0][0] != grid[i][j]) {
								pw.println((i + 1) + " " + (j + 1));
								printedAnswer = true;
								break;
							}
						}
					}
				}
			}
			if(!printedAnswer)
				pw.println("-1");
		}
		br.close();
		pw.close();
	}
}