package Dec2016Silver;
import java.util.*;
import java.io.*;
public class moocast {
	static int n, x[], y[], p[];
	static boolean reached[], b[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("moocast.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("moocast.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = new int[n];
		y = new int[n];
		p = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		b = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int d = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
				if (d <= p[i] * p[i])
					b[i][j] = true;
			}
		}
		int ans = 1;
		for (int i = 0; i < n; i++) {
			reached = new boolean[n];
			ans = Math.max(ans, dfs(i));
		}
		pw.println(ans);
		br.close();
		pw.close();
	}
	public static int dfs(int temp) {
		if(reached[temp]) {
			return 0;
		}
		reached[temp] = true;
		int ans = 1;
		for(int i = 0; i < b[temp].length; i++) {
			if(b[temp][i]) {
				ans += dfs(i);
			}
		}
		return ans;
	}
}