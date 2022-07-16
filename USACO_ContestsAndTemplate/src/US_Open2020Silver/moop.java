package US_Open2020Silver;
import java.util.*;
import java.io.*;
public class moop {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("moop.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("moop.out")));
		int n = Integer.parseInt(br.readLine());
		Pair[] pair = new Pair[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pair[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(pair);
		int[] lmin = new int[n];
		int[] rmax = new int[n];
		int count = 1;
		lmin[0] = pair[0].getY();
		for(int i = 1; i < n; i++)
			lmin[i] = Math.min(lmin[i - 1], pair[i].getY());
		rmax[n - 1] = pair[n - 1].getY();
		for(int i = n - 2; i >= 0; i--)
			rmax[i] = Math.max(rmax[i + 1], pair[i].getY());
		for(int i = 0; i < n - 1; i++)
			if(lmin[i] > rmax[i + 1])
				++count;
		pw.println(count);
		br.close();
		pw.close();
	}
}
class Pair implements Comparable<Pair> {
	private int f, s;
	public int compareTo(Pair p) {
		return f != p.f ? f - p.f : s - p.s;
	}
	public Pair(int one, int two) {
		this.f = one;
		this.s = two;
	}
	public int getX() {
		return f;
	}
	public int getY() {
		return s;
	}
	public String toString() {
		return f + " " + s;
	}
}