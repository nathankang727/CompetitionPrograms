import java.util.*;
import java.io.*;
public class moop {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] p = new Point[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(p);
		int[] lmin = new int[n];
		int[] rmax = new int[n];
		int count = 1;
		lmin[0] = p[0].y;
		for(int i = 1; i < n; i++)
			lmin[i] = Math.min(lmin[i - 1], p[i].y);
		rmax[n - 1] = p[n - 1].y;
		for(int i = n - 2; i >= 0; i--)
			rmax[i] = Math.max(rmax[i + 1], p[i].y);
		for(int i = 0; i < n - 1; i++)
			if(lmin[i] > rmax[i + 1])
				++count;
		System.out.println(count);
		br.close();
	}
	static class Point implements Comparable<Point> {
		public int x, y;
		public int compareTo(Point p) {
			if(this.x == p.x)
				return this.y -p.y;
			return this.x - p.x;
		}
		public Point(int xx, int yy) {
			this.x = xx;
			this.y = yy;
		}
	}
}