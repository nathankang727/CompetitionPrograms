package US_Open2020Bronze;
import java.util.*;
import java.io.*;
public class socdist2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("socdist2.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("socdist2.out")));
		int n = Integer.parseInt(br.readLine());
		Infected[] cows = new Infected[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int input1 = Integer.parseInt(st.nextToken());
			boolean input2 = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			cows[i] = new Infected(input1, input2);
		}
		Arrays.sort(cows);
		int maxRadius = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			if(i == 0 && !cows[i].d && cows[i + 1].d || i > 0 && i < n - 1 && !cows[i].d && !cows[i - 1].d && cows[i + 1].d)
				maxRadius = Math.min(maxRadius, cows[i + 1].p - cows[i].p - 1);
			else if(i == n - 1 && !cows[i].d && cows[i - 1].d || i < n - 1 && !cows[i].d && !cows[i + 1].d && cows[i - 1].d)
				maxRadius = Math.min(maxRadius, cows[i].p - cows[i - 1].p - 1);
			else if(i > 0 && i < n - 1 && !cows[i].d && cows[i - 1].d && cows[i + 1].d)
				maxRadius = Math.min(maxRadius, Math.min(cows[i].p - cows[i - 1].p - 1, cows[i + 1].p - cows[i].p - 1));
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++)
			if(cows[i].d)
				list.add(cows[i].p);
		int index = 0;
		boolean continueUsingIndex = false;
		for(int i = 0; i < list.size(); i++) {
			if(!continueUsingIndex) {
				continueUsingIndex = true;
				++index;
			}
			if(i < list.size() - 1 && list.get(i) + maxRadius < list.get(i + 1))
				continueUsingIndex = false;
		}
		pw.println(index);
		br.close();
		pw.close();
	}
	static class Infected implements Comparable<Infected> {
		public int p;
		public boolean d;
		public int compareTo(Infected i) {
			return this.p - i.p;
		}
		public Infected(int position, boolean diseased) {
			this.p = position;
			this.d = diseased;
		}
	}
}