import java.util.*;
import java.io.*;
public class snowboots {
	static int n, b, f[], min;
	static Boots boots[];
	static boolean memo[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		f = new int[n];
		memo = new boolean[n + 1][b + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			f[i] = Integer.parseInt(st.nextToken());
		boots = new Boots[b];
		for(int i = 0; i < b; i++) {
			st = new StringTokenizer(br.readLine());
			boots[i] = new Boots(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		min = b;
		dfs(0, 0);
		System.out.println(min);
		br.close();
	}
	static class Boots {
		public int d, s;
		public Boots(int depth, int stepSize) {
			this.d = depth;
			this.s = stepSize;
		}
	}
	public static void dfs(int pos, int bIndex) {
		if(bIndex >= b || memo[pos][bIndex])
			return;
		else if(boots[bIndex].d < f[pos])
			return;
		else if(pos == n - 1) {
			min = Math.min(min, bIndex);
			return;
		}
		memo[pos][bIndex] = true;
		for(int i = 1; i <= boots[bIndex].s; i++)
			dfs(Math.min(pos + i, n - 1), bIndex);
		for(int i = bIndex + 1; i < b; i++)
			dfs(pos, i);
	}
}