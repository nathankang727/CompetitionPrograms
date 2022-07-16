import java.util.*;
import java.io.*;
public class reduce {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] p = new Point[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Set<Integer> setMinX = new HashSet<Integer>();
		Set<Integer> setMaxX = new HashSet<Integer>();
		Set<Integer> setMinY = new HashSet<Integer>();
		Set<Integer> setMaxY = new HashSet<Integer>();
		Point2 point2 = new Point2();
		Arrays.sort(p);
		setMinX.add(p[0].x);
		setMinX.add(p[1].x);
		setMinX.add(p[2].x);
		setMinX.add(p[3].x);
		setMaxX.add(p[p.length - 1].x);
		setMaxX.add(p[p.length - 2].x);
		setMaxX.add(p[p.length - 3].x);
		setMaxX.add(p[p.length - 4].x);
		Arrays.sort(p, point2);
		setMinY.add(p[0].y);
		setMinY.add(p[1].y);
		setMinY.add(p[2].y);
		setMinY.add(p[3].y);
		setMaxY.add(p[p.length - 1].y);
		setMaxY.add(p[p.length - 2].y);
		setMaxY.add(p[p.length - 3].y);
		setMaxY.add(p[p.length - 4].y);
		int min = Integer.MAX_VALUE;
		for(int i : setMinX) {
			for(int j : setMaxX) {
				for(int k : setMinY) {
					for(int l : setMaxY) {
						int cnt = 0;
						for(int m = 0; m < p.length; m++)
							if(p[m].x < i || p[m].x > j || p[m].y < k || p[m].y > l)
								++cnt;
						if(cnt <= 3)
							min = Math.min(min, (j - i) * (l - k));
					}
				}
			}
		}
		System.out.println(min);
		br.close();
	}
	static class Point implements Comparable<Point> {
		public int x, y;
		public int compareTo(Point p) {
			return this.x - p.x;
		}
		public Point(int xx, int yy) {
			this.x = xx;
			this.y = yy;
		}
	}
	static class Point2 implements Comparator<Point> {
		public int compare(Point p1, Point p2) {
			return p1.y - p2.y;
		}
	}
}