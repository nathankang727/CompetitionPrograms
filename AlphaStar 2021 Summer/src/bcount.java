import java.util.*;
import java.io.*;
public class bcount {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] holsteins = new int[n];
		int[] guernseys = new int[n];
		int[] jerseys = new int[n];
		for(int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if(i > 0) {
				holsteins[i] = holsteins[i - 1];
				guernseys[i] = guernseys[i - 1];
				jerseys[i] = jerseys[i - 1];
			}
			if(input == 1)
				++holsteins[i];
			else if(input == 2)
				++guernseys[i];
			else
				++jerseys[i];
		}
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			System.out.print(a == 0 ? holsteins[b] : holsteins[b] - holsteins[a - 1]);
			System.out.print(" " + (a == 0 ? guernseys[b] : guernseys[b] - guernseys[a - 1]) + " ");
			System.out.print(a == 0 ? jerseys[b] : jerseys[b] - jerseys[a - 1]);
			System.out.println();
		}
		br.close();
	}
}