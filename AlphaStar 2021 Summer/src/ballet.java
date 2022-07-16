import java.io.*;
public class ballet {
	static int minX, minY, maxX, maxY, d;
	static Point feet[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean didBreak = false;
		minX = Integer.MAX_VALUE;
		minY = Integer.MAX_VALUE;
		maxX = Integer.MIN_VALUE;
		maxY = Integer.MIN_VALUE;
		d = 0;
		feet = new Point[4];
		feet[0] = new Point(0, 1);
		feet[1] = new Point(1, 1);
		feet[2] = new Point(0, 0);
		feet[3] = new Point(1, 0);
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			if(!move(input)) {
				System.out.println("-1");
				didBreak = true;
				break;
			}
		}
		if(!didBreak)
			System.out.println((maxY - minY + 1) * (maxX - minX + 1));
		br.close();
	}
	public static boolean move(String s) {
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int f = 0;
		if(s.substring(0, 2).equals("FR"))
			f = 1;
		else if(s.substring(0, 2).equals("RL"))
			f = 2;
		else if(s.substring(0, 2).equals("RR"))
			f = 3;
		if(s.charAt(2) == 'P') {
			for(int i = 0; i < 4; i++) {
				if(i == f)
					continue;
				feet[i] = new Point(feet[f].x + feet[i].y - feet[f].y, feet[f].y + feet[f].x - feet[i].x);
			}
			d = (d + 1) % 4;
		}
		else {
			int m = 3;
			if(s.charAt(2) == 'F')
				m = 0;
			else if(s.charAt(2) == 'R')
				m = 1;
			else if(s.charAt(2) == 'B')
				m = 2;
			m = (m + d) % 4;
			feet[f] = new Point(feet[f].x + dx[m], feet[f].y + dy[m]);
			for(int i = 0; i < 4; i++)
				if(i != f && feet[i].x == feet[f].x && feet[i].y == feet[f].y)
					return false;
		}
		for(int i = 0; i < 4; i++) {
			minX = Math.min(minX, feet[i].x);
			maxX = Math.max(maxX, feet[i].x);
			minY = Math.min(minY, feet[i].y);
			maxY = Math.max(maxY, feet[i].y);
		}
		return true;
	}
	static class Point {
		public int x;
		public int y;
		public Point(int xx, int yy) {
			this.x = xx;
			this.y = yy;
		}
	}
}