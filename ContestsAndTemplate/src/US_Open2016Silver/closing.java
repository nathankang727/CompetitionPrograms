package US_Open2016Silver;
import java.util.*;
import java.io.*;
public class closing {
	static int n, m, count;
	static boolean[] v;
	static ArrayList<ArrayList<Integer>> connections;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("closing.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("closing.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		connections = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= n; i++)
			connections.add(new ArrayList<Integer>());
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connections.get(a).add(b);
			connections.get(b).add(a);
		}
		int farms = n;
		v = new boolean[n + 1];
		count = 1;
		dfs(1);
		pw.println(farms <= count ? "YES" : "NO");
		int[] inputs = new int[n + 1];
		for(int i = 1; i <= n; i++)
			inputs[i] = Integer.parseInt(br.readLine());
		int test = inputs[n];
		for(int i = 1; i < n; i++) {
			int closing = inputs[i];
			connections.get(closing).clear();
			for(int j = 1; j <= n; j++)
				for(int k = connections.get(j).size() - 1; k >= 0; k--)
					if(connections.get(j).get(k) == closing)
						connections.get(j).remove(k);
			--farms;
			v = new boolean[n + 1];
			count = 1;
			dfs(test);
			pw.println(farms <= count ? "YES" : "NO");
		}
		br.close();
		pw.close();
	}
	public static void dfs(int s) {
		v[s] = true;
		for(int i = 0; i < connections.get(s).size(); i++) {
			if(!v[connections.get(s).get(i)]) {
				++count;
				dfs(connections.get(s).get(i));
			}
		}
	}
}