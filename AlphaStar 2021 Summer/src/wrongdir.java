import java.util.*;
import java.io.*;
public class wrongdir {
	static char s[];
	static Point p[], temp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine().toCharArray();
		int ans = 1;
		int x = 0;
		int y = 0;
		int d = 0;
		int n = 0;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		temp = new Point[s.length + 1];
		for(int i = 0; i < s.length + 1; i++)
			temp[i] = new Point(0, 0);
		p = new Point[s.length * 2];
		for(int i = 0; i < s.length * 2; i++)
			p[i] = new Point(0, 0);
		for(int i = s.length - 1; i >= 0; i--) {
			if(s[i] == 'F') {
				temp[i].x = temp[i + 1].x;
				temp[i].y = temp[i + 1].y + 1;
			}
			else if(s[i] == 'L') {
				temp[i].x = -temp[i + 1].y;
				temp[i].y = temp[i + 1].x;
			}
			else {
				temp[i].x = temp[i + 1].y;
				temp[i].y = -temp[i + 1].x;
			}
		}
		for(int i = 0; i < s.length; i++) {
			if(s[i] == 'F') {
				p[n].x = x + rotateX((d + 3) % 4, temp[i + 1]);
				p[n].y = y + rotateY((d + 3) % 4, temp[i + 1]);
				++n;
				p[n].x = x + rotateX((d + 1) % 4, temp[i + 1]);
				p[n].y = y + rotateY((d + 1) % 4, temp[i + 1]);
				++n;
				x += dx[d];
				y += dy[d];
			}
			else if(s[i] == 'L') {
				p[n].x = x + dx[d] + rotateX(d, temp[i + 1]);
				p[n].y = y + dy[d] + rotateY(d, temp[i + 1]);
				++n;
				p[n].x = x + rotateX((d + 1) % 4, temp[i + 1]);
				p[n].y = y + rotateY((d + 1) % 4, temp[i + 1]);
				++n;
				d = (d + 3) % 4;
			}
			else {
				p[n].x = x + dx[d] + rotateX(d, temp[i + 1]);
				p[n].y = y + dy[d] + rotateY(d, temp[i + 1]);
				++n;
				p[n].x = x + rotateX((d + 3) % 4, temp[i + 1]);
				p[n].y = y + rotateY((d + 3) % 4, temp[i + 1]);
				++n;
				d = (d + 1) % 4;
			}
		}
		Arrays.sort(p);
		for(int i = 1; i < s.length * 2; i++)
			if(p[i].x != p[i - 1].x || p[i].y != p[i - 1].y)
				++ans;
		System.out.println(ans);
		br.close();
	}
	static class Point implements Comparable<Point>{
		public int x, y;
		public int compareTo(Point p) {
			if(this.x == p.x)
				return this.y - p.y;
			return this.x - p.x;
		}
		public Point(int xx, int yy) {
			this.x = xx;
			this.y = yy;
		}
	}
	public static int rotateX(int d, Point p) {
		if(d == 0)
			return p.x;
		else if(d == 1)
			return p.y;
		else if(d == 2)
			return -p.x;
		return -p.y;
	}
	public static int rotateY(int d, Point p) {
		if(d == 0)
			return p.y;
		else if(d == 1)
			return -p.x;
		else if(d == 2)
			return -p.y;
		return p.x;
	}
}