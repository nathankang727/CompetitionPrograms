package Feb2018Silver;
import java.util.*;
import java.io.*;
public class reststops {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("reststops.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("reststops.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		long n = Long.parseLong(st.nextToken());
		long f = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		ArrayList<Stops> stops = new ArrayList<Stops>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int position = Integer.parseInt(st.nextToken());
			int taste = Integer.parseInt(st.nextToken());
			stops.add(new Stops(position, taste));
		}
		Collections.sort(stops);
		long ans = 0;
		long pos = 0;
		while(!stops.isEmpty()) {
			if(stops.get(0).p >= pos) {
				ans += (stops.get(0).p - pos) * (f - b) * stops.get(0).t;
				pos = stops.get(0).p;
			}
			stops.remove(0);
		}
		pw.println(ans);
		br.close();
		pw.close();
	}
	static class Stops implements Comparable<Stops> {
		public long p;
		public long t;
		public int compareTo(Stops s) {
			return (int)(s.t - this.t);
		}
		public Stops(long pos, long tas) {
			this.p = pos;
			this.t = tas;
		}
	}
}