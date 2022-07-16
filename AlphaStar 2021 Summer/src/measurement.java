import java.util.*;
import java.io.*;
public class measurement {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		Measure[] data = new Measure[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			data[i] = new Measure(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(data);
		int boardMilk = g;
		int boardCow = 1000000000;
		TreeMap<Integer, Integer> milkMap = new TreeMap<Integer, Integer>();
		milkMap.put(g, 1000000000);
		HashMap<Integer, Integer> cowMap = new HashMap<Integer, Integer>();
		int changes = 0;
		for(int i = 0; i < n; i++) {
			int currentMilk = cowMap.containsKey(data[i].id) ? cowMap.get(data[i].id) : g;
			milkMap.put(currentMilk, milkMap.get(currentMilk) - 1);
			if(milkMap.get(currentMilk) == 0)
				milkMap.remove(currentMilk);
			if(currentMilk == boardMilk)
				boardMilk += data[i].c;
			currentMilk += data[i].c;
			if(!milkMap.containsKey(currentMilk))
				milkMap.put(currentMilk, 1);
			else
				milkMap.put(currentMilk, milkMap.get(currentMilk) + 1);
			cowMap.put(data[i].id, currentMilk);
			int maxMilk = milkMap.lastKey();
			int maxCow = milkMap.get(maxMilk);
			if(maxMilk != boardMilk || maxCow != boardCow) {
				++changes;
				boardMilk = maxMilk;
				boardCow = maxCow;
			}
		}
		System.out.println(changes);
		br.close();
	}
	static class Measure implements Comparable<Measure> {
		public int d, id, c;
		public int compareTo(Measure m) {
			return this.d - m.d;
		}
		public Measure(int day, int ID, int change) {
			this.d = day;
			this.id = ID;
			this.c = change;
		}
	}
}