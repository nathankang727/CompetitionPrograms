package Dec2018Silver;
import java.util.*;
import java.io.*;
public class convention2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("convention2.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("convention2.out")));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Data> list = new LinkedList<Data>();
		PriorityQueue<Data> pq = new PriorityQueue<Data>(n, new Seniority());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
		}
		Collections.sort(list);
		int maxWait = 0;
		boolean wait = false;
		int time = list.get(0).a;
		while(list.size() > 0) {
			time += list.remove(0).t;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(0).a > time)
					break;
				pq.add(list.remove(0));
			}
			if(pq.size() > 0) {
				list.addFirst(pq.remove());
				wait = true;
			}
			else
				wait = false;
			if(wait)
				maxWait = Math.max(maxWait, time - list.get(0).a);
			else if(!wait && list.size() > 0)
				time = list.get(0).a;
		}
		pw.println(maxWait);
		br.close();
		pw.close();
	}
	static class Data implements Comparable<Data> {
		public int a, t, s;
		public int compareTo(Data d) {
			return this.a - d.a;
		}
		public Data(int arrival, int time, int seniority) {
			this.a = arrival;
			this.t = time;
			this.s = seniority;
		}
	}
	static class Seniority implements Comparator<Data> {
		public int compare(Data d1, Data d2) {
			return d1.s - d2.s;
		}
	}
}