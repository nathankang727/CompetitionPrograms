package Jan2018Silver;
import java.util.*;
import java.io.*;
public class rental {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("rental.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("rental.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		Integer[] milk = new Integer[n];
		for(int i = 0; i < n; i++)
			milk[i] = Integer.parseInt(br.readLine());
		Arrays.sort(milk, Collections.reverseOrder());
		LinkedList<Store> store = new LinkedList<Store>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			store.add(new Store(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(store);
		LinkedList<Integer> rentals = new LinkedList<Integer>();
		for(int i = 0; i < r; i++)
			rentals.add(Integer.parseInt(br.readLine()));
		Collections.sort(rentals, Collections.reverseOrder());
		long[] sellingMilkProfit = new long[n];
		for(int i = 0; i < n; i++) {
			int cnt = milk[i];
			while(cnt > 0 && store.size() > 0) {
				int sc = store.get(0).c;
				int ss = store.get(0).s;
				if(cnt < ss) {
					sellingMilkProfit[i] += (long)(cnt) * (long)(sc);
					store.set(0, new Store(ss - cnt, sc));
					cnt = 0;
				}
				else {
					cnt -= ss;
					sellingMilkProfit[i] += (long)(ss) * (long)(sc);
					store.remove(0);
				}
			}
		}
		long stonks = 0;
		for(int i = n - 1; i >= 0; i--) {
			if(rentals.size() > 0 && sellingMilkProfit[i] < (long)(rentals.get(0))) {
				stonks += (long)(rentals.get(0));
				rentals.remove(0);
			}
			else
				stonks += sellingMilkProfit[i];
		}
		pw.println(stonks);
		br.close();
		pw.close();
	}
	static class Store implements Comparable<Store> {
		public int s, c;
		public int compareTo(Store s) {
			return s.c - this.c;
		}
		public Store(int storage, int cost) {
			this.s = storage;
			this.c = cost;
		}
	}
}