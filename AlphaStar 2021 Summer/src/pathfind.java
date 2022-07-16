import java.util.*;
import java.io.*;
public class pathfind {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] a = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		int[] distance = new int[n + 1];
		Arrays.fill(distance, 2 * n);
		Queue<Integer> q = new LinkedList<Integer>();
		distance[m] = 0;
		q.add(m);
		while(!q.isEmpty()) {
			int current = q.peek();
			q.remove();
			for(int i = 1; i <= n; i++) {
				if(a[current][i] == 1 && distance[i] > distance[current] + 1) {
					distance[i] = distance[current] + 1;
					q.add(i);
				}
			}
		}
		ArrayList<Output> o = new ArrayList<Output>();
		for(int i = 1; i <= n; i++)
			if(distance[i] != n * 2)
				o.add(new Output(i, distance[i]));
		Collections.sort(o);
		int temp = o.get(0).v;
		for(int i = 0; i < o.size(); i++) {
			if(temp != o.get(i).v) {
				System.out.println();
				temp = o.get(i).v;
			}
			System.out.print(o.get(i).i + " ");
		}
		br.close();
	}
	static class Output implements Comparable<Output> {
		public int i, v;
		public int compareTo(Output o) {
			if(this.v == o.v)
				return this.i - o.i;
			return this.v - o.v;
		}
		public Output(int index, int value) {
			this.i = index;
			this.v = value;
		}
	}
}