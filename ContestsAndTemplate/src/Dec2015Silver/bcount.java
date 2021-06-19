package Dec2015Silver;
import java.util.*;
import java.io.*;
public class bcount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("bcount.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("bcount.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] input = new int[n];
		for(int i = 0; i < n; i++)
			input[i] = Integer.parseInt(br.readLine());
		cowTypes[] cows = new cowTypes[n];
		int hCount = 0;
		int gCount = 0;
		int jCount = 0;
		for(int i = 0; i < n; i++) {
			if(input[i] == 1)
				++hCount;
			else if(input[i] == 2)
				++gCount;
			else
				++jCount;
			cows[i] = new cowTypes(hCount, gCount, jCount);
		}
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			if(start == 0)
				pw.println(cows[end].h + " " + cows[end].g + " " + cows[end].j);
			else {
				int ans1 = cows[end].h - cows[start - 1].h;
				int ans2 = cows[end].g - cows[start - 1].g;
				int ans3 = cows[end].j - cows[start - 1].j;
				pw.println(ans1 + " " + ans2 + " " + ans3);
			}
		}
		br.close();
		pw.close();
	}
	static class cowTypes {
		public int h, g, j;
		public cowTypes(int holsteins, int guernseys, int jerseys) {
			this.h = holsteins;
			this.g = guernseys;
			this.j = jerseys;
		}
	}
}