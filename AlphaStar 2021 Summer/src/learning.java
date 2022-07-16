import java.util.*;
import java.io.*;
public class learning {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		cowSpots[] cows = new cowSpots[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new cowSpots(st.nextToken().equals("S"), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cows);
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(!cows[i].hs)
				continue;
			int low = i > 0 ? (cows[i - 1].w + cows[i].w) / 2 + (cows[i - 1].w + cows[i].w) % 2 : Integer.MIN_VALUE;
			int high = i < n - 1 ? (cows[i].w + cows[i + 1].w) / 2 : Integer.MAX_VALUE;
			ans += Math.max(a, low) > Math.min(b, high) ? 0 : Math.min(b, high) - Math.max(a, low) + 1;
		}
		for(int i = 0; i < n - 1; i++)
			if(cows[i].hs && cows[i + 1].hs)
				if((cows[i].w + cows[i + 1].w) % 2 == 0 && a <= (cows[i].w + cows[i + 1].w) / 2 && (cows[i].w + cows[i + 1].w) / 2 <= b)
					--ans;
		System.out.println(ans);
		br.close();
	}
	static class cowSpots implements Comparable<cowSpots> {
		public boolean hs;
		public int w;
		public int compareTo (cowSpots cs) {
			return this.w - cs.w;
		}
		public cowSpots(boolean hasSpots, int weight) {
			this.hs = hasSpots;
			this.w = weight;
		}
	}
}