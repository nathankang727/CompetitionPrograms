import java.util.*;
import java.io.*;
public class farmoff {
	static long d, h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		d = Long.parseLong(st.nextToken());
		long e = Long.parseLong(st.nextToken());
		long f = Long.parseLong(st.nextToken());
		long g = Long.parseLong(st.nextToken());
		h = Long.parseLong(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Data[] cows = new Data[n * 3];
		for(int i = 0; i < n * 3; i++) {
			long w = (a * calculateModPower1(i, 5) + b * calculateModPower1(i, 2) + c) % d;
			long u = (e * calculateModPower2(i, 5) + f * calculateModPower2(i, 3) + g) % h;
			cows[i] = new Data(u, w);
		}
		Arrays.sort(cows);
		long ans = 0;
		for(int i = 0; i < n; i++)
			ans = (ans + cows[i].w) % m;
		System.out.println(ans);
		br.close();
	}
	static class Data implements Comparable<Data> {
		public long u, w;
		public int compareTo(Data d) {
			if(this.u == d.u)
				return (int)(this.w - d.w);
			return (int)(d.u - this.u);
		}
		public Data(long utility, long weight) {
			this.u = utility;
			this.w = weight;
		}
	}
	public static long calculateModPower1(int b, int e) {
		long res = 1;
		for(int i = 0; i < e; i++)
			res = res * b % d;
		return res;
	}
	public static long calculateModPower2(int b, int e) {
		long res = 1;
		for(int i = 0; i < e; i++)
			res = res * b % h;
		return res;
	}
}