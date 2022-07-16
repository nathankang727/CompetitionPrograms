import java.util.*;
import java.io.*;
public class convention2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Cow> c = new LinkedList<Cow>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
		}
		Collections.sort(c);
		int ans = 0;
		PriorityQueue<Cow> pq = new PriorityQueue<Cow>(n, new Seniority());
		boolean wait = false;
		int time = c.get(0).a;
		while(!pq.isEmpty()) {
			time += c.remove(0).t;
			for(int i = 0; i < c.size(); i++) {
				if(c.get(i).a > time)
					break;
				pq.add(c.get(i));
			}
			if(pq.size() > 0) {
				c.add(0, pq.remove());
				wait = true;
			}
			else
				wait = false;
			if(wait)
				ans = Math.max(ans, time - c.get(0).a);
			else if(!wait && !c.isEmpty())
				time = c.get(0).a;
		}
		System.out.println(ans);
		br.close();
	}
	static class Cow implements Comparable<Cow> {
		public int a, t, s;
		public int compareTo(Cow c) {
			if(this.a == c.a)
				return this.s - c.s;
			return this.a - c.a;
		}
		public Cow(int arrival, int time, int seniority) {
			this.a = arrival;
			this.t = time;
			this.s = seniority;
		}
	}
	static class Seniority implements Comparator<Cow> {
		public int compare(Cow c1, Cow c2) {
			return c1.s - c2.s;
		}
	}
}