package Dec2020Bronze;
import java.util.*;
import java.io.*;
public class StuckInARut_Bronze {
	static int n, x[], y[];
	static char[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		x = new int[n];
		y = new int[n];
		d = new char[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d[i] = st.nextToken().charAt(0);
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) {
			int temp = check(i);
			if(temp == Integer.MAX_VALUE)
				System.out.println("Infinity");
			else
				System.out.println(temp);
		}
		br.close();
	}
	public static int check(int num) {
		int min = Integer.MAX_VALUE;
		if(d[num] == 'E') {
			for(int i = 0; i < n; i++) {
				if(num == i || d[i] == 'E'|| x[num] > x[i] || y[num] < y[i])
					continue;
				int dx = x[i] - x[num];
				int dy = y[num] - y[i];
				if(dx > dy && check(i) > dy)
					min = Math.min(min, dx);
			}
		}
		else {
			for(int i = 0; i < n; i++) {
				if(num == i || d[i] == 'N' || x[num] < x[i] || y[num] > y[i])
					continue;
				int dx = x[num] - x[i];
				int dy = y[i] - y[num];
				if(dx < dy && check(i) > dx)
					min = Math.min(min, dy);
			}
		}
		return min;
	}
}