package Dec2015Silver;
import java.util.*;
import java.io.*;
public class bcount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("bcount.in")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new FileWriter(new File("bcount.out")));
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[][] cows = new int[n][3];
		for(int i = 0; i < n; i++) {
			if(i > 0) {
				cows[i][0] = cows[i - 1][0];
				cows[i][1] = cows[i - 1][1];
				cows[i][2] = cows[i - 1][2];
			}
			int id = Integer.parseInt(br.readLine());
			++cows[i][id - 1];
		}
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			if(start > 0) {
				pw.print((cows[end][0] - cows[start - 1][0]) + " " + (cows[end][1] - cows[start - 1][1]) + " ");
				pw.print(cows[end][2] - cows[start - 1][2] + "\n");
			}
			else
				pw.println(cows[end][0] + " " + cows[end][1] + " " + cows[end][2]);
		}
		br.close();
		pw.close();
	}
}