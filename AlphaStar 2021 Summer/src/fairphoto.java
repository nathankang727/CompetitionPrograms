import java.util.*;
import java.io.*;
public class fairphoto {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Cows[] cows = new Cows[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cows[i] = new Cows(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0) == 'G' ? 1 : -1);
		}
		Arrays.sort(cows);
		int[] prefixSum = new int[n];
		int pS = 0;
		for(int i = 0; i < n; i++) {
			pS += cows[i].b;
			prefixSum[i] = pS;
		}
		int ans = Math.max(allG(n, cows), allH(n, cows));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++) {
			if(prefixSum[i] == 0)
				ans = Math.max(ans, cows[i].x - cows[0].x);
			else if(!map.containsKey(prefixSum[i]))
				map.put(prefixSum[i], i);
			else
				ans = Math.max(ans, cows[i].x - cows[map.get(prefixSum[i]) + 1].x);
		}
		System.out.println(ans);
		br.close();
	}
	static class Cows implements Comparable<Cows> {
		public int x, b;
		public int compareTo(Cows c) {
			return this.x - c.x;
		}
		public Cows(int position, int breed) {
			this.x = position;
			this.b = breed;
		}
	}
	public static int allG(int n, Cows[] cows) {
		int cnt = 0;
		int temp = -1;
		for(int i = 0; i < n; i++) {
			if(cows[i].b == 1 && temp == -1)
				temp = i;
			else if(cows[i].b == 1 && temp != -1)
				cnt = Math.max(cnt, cows[i].x - cows[temp].x);
			else
				temp = -1;
		}
		return cnt;
	}
	public static int allH(int n, Cows[] cows) {
		int cnt = 0;
		int temp = -1;
		for(int i = 0; i < n; i++) {
			if(cows[i].b == -1 && temp == -1)
				temp = i;
			else if(cows[i].b == -1 && temp != -1)
				cnt = Math.max(cnt, cows[i].x - cows[temp].x);
			else
				temp = -1;
		}
		return cnt;
	}
}