import java.util.*;
import java.io.*;
public class fenceplan {
	static int n, m, coor[][], minX, maxX, minY, maxY;
	static ArrayList<Integer>[] adj;
	static boolean visited[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		coor = new int[n + 1][2];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			coor[i][0] = Integer.parseInt(st.nextToken());
			coor[i][1] = Integer.parseInt(st.nextToken());
		}
		adj = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++)
			adj[i] = new ArrayList<Integer>();
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		visited = new boolean[n + 1];
		int ans = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				minX = Integer.MAX_VALUE;
				maxX = Integer.MIN_VALUE;
				minY = Integer.MAX_VALUE;
				maxY = Integer.MIN_VALUE;
				dfs(i);
				ans = Math.min(ans, 2 * (maxX - minX) + 2 * (maxY - minY));
			}
		}
		System.out.println(ans);
		br.close();
	}
	public static void dfs(int index) {
		if(visited[index])
			return;
		visited[index] = true;
		minX = Math.min(minX, coor[index][0]);
		maxX = Math.max(maxX, coor[index][0]);
		minY = Math.min(minY, coor[index][1]);
		maxY = Math.max(maxY, coor[index][1]);
		for(int i = 0; i < adj[index].size(); i++) {
			dfs(adj[index].get(i));
		}
	}
}