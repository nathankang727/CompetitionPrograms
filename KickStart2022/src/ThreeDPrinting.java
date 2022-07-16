import java.util.*;
import java.io.*;
public class ThreeDPrinting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			int[] c = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
			for(int j = 0; j < 3; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				c[0] = Math.min(c[0], Integer.parseInt(st.nextToken()));
				c[1] = Math.min(c[1], Integer.parseInt(st.nextToken()));
				c[2] = Math.min(c[2], Integer.parseInt(st.nextToken()));
				c[3] = Math.min(c[3], Integer.parseInt(st.nextToken()));
			}
			if(c[0] + c[1] + c[2] + c[3] < 1000000)
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			else {
				System.out.print("Case #" + i + ":");
				int paint = 1000000;
				for(int j = 0; j < 4; j++) {
					if(c[j] >= paint) {
						System.out.print(" " + paint);
						paint = 0;
					}
					else {
						paint -= c[j];
						System.out.print(" " + c[j]);
					}
				}
				System.out.print("\n");
			}
		}
		br.close();
	}
}