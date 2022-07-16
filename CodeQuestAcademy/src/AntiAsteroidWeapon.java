import java.util.*;
public class AntiAsteroidWeapon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int a = sc.nextInt();
			dist[] asteroids = new dist[a];
			for(int j = 0; j < a; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				asteroids[j] = new dist(x, y, Math.sqrt((double)(x * x + y * y)));
			}
			Arrays.sort(asteroids);
			for(int j = 0; j < a; j++)
				System.out.println(asteroids[j].x + " " + asteroids[j].y);
		}
		sc.close();
	}
	static class dist implements Comparable<dist> {
		public int x, y;
		public Double d;
		public int compareTo(dist D) {
			return this.d.compareTo(D.d);
		}
		public dist(int xx, int yy, Double dd) {
			this.x = xx;
			this.y = yy;
			this.d = dd;
		}
	}
}