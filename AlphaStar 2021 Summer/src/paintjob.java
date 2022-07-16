import java.util.*;
import java.io.*;
public class paintjob {
	static int a, b, n, p, paints[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		paints = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			paints[i] = Integer.parseInt(st.nextToken());
		System.out.println(bfs());
		br.close();
	}
	public static int bfs() {
		int[] sol = new int[p + 1];
		for(int i = 0; i < p + 1; i++)
			sol[i] = Integer.MAX_VALUE;
		Queue<Integer> q = new LinkedList<Integer>();
		sol[a] = 0;
		q.add(a);
		while(!q.isEmpty()) {
			int curx = q.peek();
			q.remove();
			for(int i = 0; i < n; i++) {
				int nxtx = curx * paints[i] % p;
				if(sol[nxtx] == Integer.MAX_VALUE) {
					sol[nxtx] = sol[curx] + 1;
					q.add(nxtx);
				}
			}
		}
		return sol[b] == Integer.MAX_VALUE ? -1 : sol[b];
	}
}