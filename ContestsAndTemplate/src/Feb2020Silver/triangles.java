package Feb2020Silver;
import java.util.*;
import java.io.*;
public class triangles {
	static Pair[] coor;
	@SuppressWarnings("rawtypes")
	static ArrayList[] temp;
	@SuppressWarnings("rawtypes")
	static ArrayList[] sum;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("triangles.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("triangles.out")));
		int n = Integer.parseInt(br.readLine());
		Pair[] coor = new Pair[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coor[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		temp = new ArrayList[20001];
		sum = new ArrayList[100005];
		for(int i = 0; i < 20001; i++)
			temp[i] = new ArrayList<Pair>();
		for(int i = 0; i < 100005; i++)
			sum[i] = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
			temp[(int)(coor[i].getX() + 10000)].add(new Pair(coor[i].getY(), i));
		check();
		for(int i = 0; i < 20001; i++)
			temp[i].clear();
		for(int i = 0; i < n; i++)
			temp[(int)(coor[i].getY() + 10000)].add(new Pair(coor[i].getX(), i));
		check();
		long res = 0;
		for(int i = 0; i < n; i++)
			res = (res + ((long)sum[i].get(0) * (long)sum[i].get(1))) % 1000000007;
		pw.println(res);
		br.close();
		pw.close();
	}
	@SuppressWarnings("unchecked")
	public static void check() {
		for(int i = 0; i < 20001; i++) {
			if(temp[i].size() > 0) {
				int s = temp[i].size();
				Collections.sort(temp[i]);
				long c = 0;
				for(int j = 0; j < s; j++)
					c = (c + (((Pair)temp[i].get(j)).getX() - ((Pair)temp[i].get(0)).getX())) % 1000000007;
				for(int j = 0; j < s; j++) {
					if(j != 0) {
						c = (c + (2 * j - s) * (((Pair)temp[i].get(j)).getX() - ((Pair)temp[i].get(j - 1)).getX())) 
								% 1000000007;
					}
					sum[(int)((Pair)temp[i].get(j)).getY()].add(c);
				}
			}
		}
	}
}
class Pair implements Comparable<Pair> {
	private int x;
	private int y;
	public int compareTo(Pair p) {
		return this.x != p.x ? this.x - p.x : this.y - p.y;
	}
	public Pair(int xx, int yy) {
		this.x = xx;
		this.y = yy;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}