import java.util.*;
import java.io.*;
public class cowjog {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] point = new Point[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int ans = 1;
		int slowest = point[n - 1].s;
		for(int i = n - 2; i >= 0; i--) {
			if(point[i].s <= slowest) {
				++ans;
				slowest = Math.min(slowest, point[i].s);
			}
		}
		System.out.println(ans);
		br.close();
	}
	static class Point {
		public int x, s;
		public Point(int position, int speed) {
			this.x = position;
			this.s = speed;
		}
	}
}