import java.util.*;
import java.io.*;
public class cheat {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> bessie = new ArrayList<Integer>();
		for(int i = 1; i <= k; i++)
			q.add(i);
		while(!q.isEmpty()) {
			for(int i = 0; i < n; i++) {
				if(i == n - 1)
					bessie.add(q.remove());
				else
					q.remove();
				if(!q.isEmpty())
					for(int j = 0; j < p; j++)
						q.add(q.remove());
			}
		}
		Collections.sort(bessie);
		for(int i = 0; i < k / n; i++)
			System.out.println(bessie.get(i));
		br.close();
	}
}