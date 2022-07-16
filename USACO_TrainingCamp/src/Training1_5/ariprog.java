/*
ID: nathank3
LANG: JAVA
TASK: ariprog
*/
package Training1_5;
import java.util.*;
import java.io.*;
public class ariprog {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("ariprog.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("ariprog.out")));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[] isBisquare = new boolean[m * m + m * m + 1];
		for(int i = 0; i <= m; i++)
			for(int j = 0; j <= m; j++)
				isBisquare[i * i + j * j] = true;
		ArrayList<resSort> list = new ArrayList<resSort>();
		for(int i = 0; i <= m * m + m * m; i++) {
			if(!isBisquare[i])
				continue;
			for(int j = 1; j <= (m * m + m * m - i) / (n - 1); j++) {
				boolean didBreak = false;
				for(int k = 1; k <= n - 1; k++) {
					if(!isBisquare[i + j * k]) {
						didBreak = true;
						break;
					}
				}
				if(didBreak)
					continue;
				list.add(new resSort(i, j));
			}
		}
		if(list.size() == 0)
			pw.println("NONE");
		else {
			Collections.sort(list);
			for(int i = 0; i < list.size(); i++)
				pw.println(list.get(i).f + " " + list.get(i).d);
		}
		br.close();
		pw.close();
	}
	static class resSort implements Comparable<resSort> {
		public int f, d;
		public int compareTo(resSort rs) {
			if(this.d == rs.d)
				return this.f - rs.f;
			return this.d - rs.d;
		}
		public resSort(int first, int difference) {
			this.f = first;
			this.d = difference;
		}
	}
}