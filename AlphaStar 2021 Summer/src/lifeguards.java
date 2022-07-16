import java.util.*;
import java.io.*;
public class lifeguards {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Timeslots[] arr = new Timeslots[2 * n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i + i] = new Timeslots(Integer.parseInt(st.nextToken()), i);
			arr[i + i + 1] = new Timeslots(Integer.parseInt(st.nextToken()), i);
		}
		Arrays.sort(arr);
		int[] aloneTime = new int[n];
		int totalTime = 0;
		int time = 0;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0; i < 2 * n; i++) {
			if(set.size() == 1)
				aloneTime[set.first()] += arr[i].t - time;
			if(set.size() > 0)
				totalTime += arr[i].t - time;
			if(set.contains(arr[i].i))
				set.remove(arr[i].i);
			else
				set.add(arr[i].i);
			time = arr[i].t;
		}
		Arrays.sort(aloneTime);
		System.out.println(totalTime - aloneTime[0]);
		br.close();
	}
	static class Timeslots implements Comparable<Timeslots> {
		public int t, i;
		public int compareTo(Timeslots ts) {
			return this.t - ts.t;
		}
		public Timeslots(int time, int index) {
			this.t = time;
			this.i = index;
		}
	}
}