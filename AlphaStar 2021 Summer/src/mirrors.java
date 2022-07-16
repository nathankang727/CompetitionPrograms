import java.util.*;
import java.io.*;
public class mirrors {
	static int n, a, b;
	static Pair mirror[];
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		mirror = new Pair[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			mirror[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken().charAt(0) == '/');
		}
		boolean hasSolution = false;
		if(works(0, 0, 0)) {
			System.out.println("0");
			hasSolution = true;
		}
		for(int i = 0; i < n; i++) {
			mirror[i] = new Pair(mirror[i].x, mirror[i].y, !mirror[i].d);
			if(works(0, 0, 0)) {
				System.out.println(i + 1);
				hasSolution = true;
				break;
			}
			mirror[i] = new Pair(mirror[i].x, mirror[i].y, !mirror[i].d);
		}
		if(!hasSolution)
			System.out.println("-1");
		br.close();
	}
	static class Pair {
		public int x;
		public int y;
		public boolean d;
		public Pair(int a, int b, boolean direction) {
			this.x = a;
			this.y = b;
			this.d = direction;
		}
	}
	public static boolean works(int x, int y, int direction) {
		int[] mirrorUsed = new int[n];
		while(true) {
			if(x <= a && y == b && direction == 0 || x >= a && y == b && direction == 1)
				return true;
			else if(x == a && y <= b && direction == 2 || x == a && y >= b && direction == 3)
				return true;
			if(direction == 0) {
				boolean hitMirror = false;
				int newX = Integer.MAX_VALUE;
				int index = 0;
				for(int i = 0; i < n; i++) {
					if(x < mirror[i].x && y == mirror[i].y && newX > mirror[i].x) {
						newX = mirror[i].x;
						index = i;
						hitMirror = true;
					}
				}
				if(!hitMirror)
					return false;
				if(mirrorUsed[index] == 2)
					return false;
				++mirrorUsed[index];
				x = newX;
				if(mirror[index].d)
					direction = 2;
				else
					direction = 3;
			}
			else if(direction == 1) {
				boolean hitMirror = false;
				int newX = Integer.MIN_VALUE;
				int index = 0;
				for(int i = 0; i < n; i++) {
					if(x > mirror[i].x && y == mirror[i].y && newX < mirror[i].x) {
						newX = mirror[i].x;
						index = i;
						hitMirror = true;
					}
				}
				if(!hitMirror)
					return false;
				if(mirrorUsed[index] == 2)
					return false;
				++mirrorUsed[index];
				x = newX;
				if(mirror[index].d)
					direction = 3;
				else
					direction = 2;
			}
			else if(direction == 2) {
				boolean hitMirror = false;
				int newY = Integer.MAX_VALUE;
				int index = 0;
				for(int i = 0; i < n; i++) {
					if(y < mirror[i].y && x == mirror[i].x && newY > mirror[i].y) {
						newY = mirror[i].y;
						index = i;
						hitMirror = true;
					}
				}
				if(!hitMirror)
					return false;
				if(mirrorUsed[index] == 2)
					return false;
				++mirrorUsed[index];
				y = newY;
				if(mirror[index].d)
					direction = 0;
				else
					direction = 1;
			}
			else if(direction == 3) {
				boolean hitMirror = false;
				int newY = Integer.MIN_VALUE;
				int index = 0;
				for(int i = 0; i < n; i++) {
					if(y > mirror[i].y && x == mirror[i].x && newY < mirror[i].y) {
						newY = mirror[i].y;
						index = i;
						hitMirror = true;
					}
				}
				if(!hitMirror)
					return false;
				if(mirrorUsed[index] == 2)
					return false;
				++mirrorUsed[index];
				y = newY;
				if(mirror[index].d)
					direction = 1;
				else
					direction = 0;
			}
		}
	}
}