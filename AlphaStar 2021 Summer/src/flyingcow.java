import java.util.*;
import java.io.*;
public class flyingcow {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(bfs(n));
		br.close();
	}
	public static int bfs(int n) {
		int[] sol = new int[n + 1];
		for(int i = 0; i < n + 1; i++)
			sol[i] = Integer.MAX_VALUE;
		Queue<Integer> q = new LinkedList<Integer>();
		sol[1] = 0;
		q.add(1);
		while(!q.isEmpty()) {
			int curx = q.peek();
			q.remove();
			int nxtx = 3 * curx;
			if(nxtx < n + 1 && sol[nxtx] > sol[curx] + 1) {
				sol[nxtx] = sol[curx] + 1;
				q.add(nxtx);
			}
			nxtx = curx + 1;
			if(nxtx < n + 1 && sol[nxtx] > sol[curx] + 1) {
				sol[nxtx] = sol[curx] + 1;
				q.add(nxtx);
			}
			nxtx = curx - 1;
			if(nxtx >= 1 && sol[nxtx] > sol[curx] + 1) {
				sol[nxtx] = sol[curx] + 1;
				q.add(nxtx);
			}
		}
		return sol[n];
	}
}
