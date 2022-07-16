import java.util.*;
import java.io.*;
public class reststops {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		int n = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int net = f - b;
		Point[] rest = new Point[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			rest[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(rest);
		int curPos = 0;
		long ans = 0;
		for(int i = 0; i < n; i++) {
			if(rest[i].x < curPos)
				continue;
			ans += ((long)(rest[i].x) - (long)(curPos)) * (long)(net) * (long)(rest[i].c);
			curPos = rest[i].x;
		}
		System.out.println(ans);
		br.close();
	}
	static class Point implements Comparable<Point> {
		public int x, c;
		public int compareTo(Point p) {
			if(this.c == p.c)
				return this.x - p.x;
			return p.c - this.c;
		}
		public Point(int location, int taste) {
			this.x = location;
			this.c = taste;
		}
	}
}