import java.io.*;
public class baleshare {
	static int res, a, b, c, n, s[];
	static boolean memo[][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n];
		for(int i = 0; i < n; i++)
			s[i] = Integer.parseInt(br.readLine());
		a = 0;
		b = 0;
		c = 0;
		res = 700;
		memo = new boolean[700][700][20];
		dfs(0);
		System.out.println(res);
		br.close();
	}
	public static void dfs(int i) {
		if(i == n) {
			res = Math.min(res, Math.max(a, Math.max(b, c)));
			return;
		}
		if(a + s[i] < res && !memo[a + s[i]][b][i]) {
			a += s[i];
			memo[a][b][i] = true;
			memo[b][a][i] = true;
			dfs(i + 1);
			memo[a][b][i] = false;
			memo[b][a][i] = false;
			a -= s[i];
		}
		if(b + s[i] < res && !memo[a][b + s[i]][i]) {
			b += s[i];
			memo[a][b][i] = true;
			memo[b][a][i] = true;
			dfs(i + 1);
			memo[a][b][i] = false;
			memo[b][a][i] = false;
			b -= s[i];
		}
		if(c + s[i] < res && !memo[a][b][i]) {
			c += s[i];
			memo[a][b][i] = true;
			memo[b][a][i] = true;
			dfs(i + 1);
			memo[a][b][i] = false;
			memo[b][a][i] = false;
			c -= s[i];
		}
	}
}