import java.util.*;
import java.io.*;
public class moocast {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] cows = new int[n][3];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
			cows[i][2] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer>[] adj = new ArrayList[n];
		for(int i = 0; i < n; i++)
			adj[i] = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j)
					continue;
				int x1 = cows[i][0];
				int y1 = cows[i][1];
				int x2 = cows[j][0];
				int y2 = cows[j][1];
				if((int)(Math.pow(x2 - x1, 2)) + (int)(Math.pow(y2 - y1, 2)) <= (int)(Math.pow(cows[i][2], 2)))
					adj[i].add(j);
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			int cnt = 1;
			boolean[] v = new boolean[n];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);
			v[i] = true;
			while(!q.isEmpty()) {
				int temp = q.remove();
				for(int j : adj[temp]) {
					if(!v[j]) {
						++cnt;
						q.add(j);
						v[j] = true;
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
		br.close();
	}
}