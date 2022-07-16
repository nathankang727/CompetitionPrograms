import java.util.*;
import java.io.*;
public class picnic {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < k; i++)
			set.add(Integer.parseInt(br.readLine()) - 1);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : set)
			list.add(i);
		ArrayList<Integer>[] adj = new ArrayList[n];
		for(int i = 0; i < n; i++)
			adj[i] = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			adj[a].add(b);
		}
		int[] access = new int[n];
		for(int i : list) {
			++access[i];
			Queue<Integer> q = new LinkedList<Integer>();
			boolean[] visited = new boolean[n];
			q.add(i);
			visited[i] = true;
			while(!q.isEmpty()) {
				int temp = q.remove();
				for(int j = 0; j < adj[temp].size(); j++) {
					if(visited[adj[temp].get(j)])
						continue;	
					q.add(adj[temp].get(j));
					visited[adj[temp].get(j)] = true;
					++access[adj[temp].get(j)];
				}
			}
		}
		int count = 0;
		for(int i = 0; i < n; i++)
			if(access[i] == list.size())
				++count;
		System.out.println(count);
	}
}