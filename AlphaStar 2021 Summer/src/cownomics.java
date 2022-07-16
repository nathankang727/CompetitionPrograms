import java.util.*;
import java.io.*;
public class cownomics {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] spotty = new String[n];
		String[] plain = new String[n];
		for(int i = 0; i < n; i++)
			spotty[i] = br.readLine().replace("A", "0").replace("T", "1").replace("C", "2").replace("G", "3");
		for(int i = 0; i < n; i++)
			plain[i] = br.readLine().replace("A", "0").replace("T", "1").replace("C", "2").replace("G", "3");
		int answer = 0;
		for(int i = 0; i < m; i++) {
			for(int j = i + 1; j < m; j++) {
				for(int k = j + 1; k < m; k++) {
					boolean[] base4 = new boolean[64];
					for(int l = 0; l < n; l++) {
						int num = Integer.parseInt(spotty[l].substring(i, i + 1)) * 16 + Integer.parseInt(spotty[l].substring(j, j + 1)) * 4;
						num += Integer.parseInt(spotty[l].substring(k, k + 1));
						base4[num] = true;
					}
					boolean works = true;
					for(int l = 0; l < n; l++) {
						int num = Integer.parseInt(plain[l].substring(i, i + 1)) * 16 + Integer.parseInt(plain[l].substring(j, j + 1)) * 4;
						num += Integer.parseInt(plain[l].substring(k, k + 1));
						if(base4[num]) {
							works = false;
							break;
						}
					}
					if(works)
						++answer;
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
}