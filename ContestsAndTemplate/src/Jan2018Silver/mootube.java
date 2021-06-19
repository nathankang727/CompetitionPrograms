package Jan2018Silver;
import java.util.*;
import java.io.*;
public class mootube {
	static int n, q, k, ans;
	static ArrayList<Weight>[] data;
	static boolean[] b;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("mootube.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("mootube.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		data = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++)
			data[i] = new ArrayList<Weight>();
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			data[p].add(new Weight(q, r));
			data[q].add(new Weight(p, r));
		}
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			ans = 0;
			b = new boolean[n + 1];
			dfs(v);
			pw.println(ans);
		}
		br.close();
		pw.close();
	}
	static class Weight {
		public int node, weight;
		public Weight(int n, int w) {
			this.node = n;
			this.weight = w;
		}
	}
	public static void dfs(int s) {
		b[s] = true;
		for(int i = 0; i < data[s].size(); i++) {
			if(!b[data[s].get(i).node] && data[s].get(i).weight >= k) {
				++ans;
				dfs(data[s].get(i).node);
			}
		}
	}
}