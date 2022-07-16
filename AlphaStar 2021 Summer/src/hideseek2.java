import java.util.*;
import java.io.*;
public class hideseek2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++)
			adj[i] = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		int maxIndex = 0;
		int maxDist = 0;
		int cnt = 0;
		for(int i = 2; i <= n; i++) {
			int[] pred = new int[n + 1];
			int[] dist = new int[n + 1];
			bfs(adj, 1, i, n, pred, dist);
			Queue<Integer> q = new LinkedList<Integer>();
			int temp = i;
			q.add(temp);
			while(pred[temp] != -1) {
				q.add(pred[temp]);
				temp = pred[temp];
			}
			if(dist[i] == maxDist)
				++cnt;
			else if(dist[i] > maxDist) {
				maxDist = dist[i];
				maxIndex = i;
				cnt = 0;
				++cnt;
			}
		}
		System.out.println(maxIndex + " " + maxDist + " " + cnt);
		br.close();
	}
	public static void bfs(ArrayList<Integer>[] adj, int src, int dest, int v, int[] pred, int[] dist) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[v + 1];
		for(int i = 1; i <= v; i++) {
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}
		visited[src] = true;
		dist[src] = 0;
		q.add(src);
		while(!q.isEmpty()) {
			int u = q.remove();
			for(int i = 0; i < adj[u].size(); i++) {
				if(!visited[adj[u].get(i)]) {
					visited[adj[u].get(i)] = true;
					dist[adj[u].get(i)] = dist[u]  + 1;
					pred[adj[u].get(i)] = u;
					q.add(adj[u].get(i));
					if(adj[u].get(i) == dest)
						return;
				}
			}
		}
	}
}