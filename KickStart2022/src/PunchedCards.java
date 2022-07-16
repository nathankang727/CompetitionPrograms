import java.util.*;
import java.io.*;
public class PunchedCards {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			System.out.println("Case #" + i + ":");
			System.out.print("..+");
			for(int j = 0; j < c - 1; j++)
				System.out.print("-+");
			System.out.print("\n..|");
			for(int j = 0; j < c - 1; j++)
				System.out.print(".|");
			System.out.print("\n+");
			for(int j = 0; j < c; j++)
				System.out.print("-+");
			for(int j = 0; j < r - 1; j++) {
				System.out.print("\n|");
				for(int k = 0; k < c; k++) {
					System.out.print(".|");
				}
				System.out.print("\n+");
				for(int k = 0; k < c; k++) {
					System.out.print("-+");
				}
			}
			System.out.println();
		}
		br.close();
	}
}