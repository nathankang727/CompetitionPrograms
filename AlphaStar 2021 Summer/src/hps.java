import java.io.*;
public class hps {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] moves = new char[n];
		for(int i = 0; i < n; i++)
			moves[i] = br.readLine().charAt(0);
		int[] paper = new int[n];
		int[] hoof = new int[n];
		int[] scissors = new int[n];
		int paperCnt = 0;
		for(int i = 0; i < n; i++) {
			if(moves[i] == 'H')
				++paperCnt;
			paper[i] = paperCnt;
		}
		int hoofCnt = 0;
		for(int i = 0; i < n; i++) {
			if(moves[i] == 'S')
				++hoofCnt;
			hoof[i] = hoofCnt;
		}
		int scissorsCnt = 0;
		for(int i = 0; i < n; i++) {
			if(moves[i] == 'P')
				++scissorsCnt;
			scissors[i] = scissorsCnt;
		}
		int[] maxPrefix = new int[n];
		for(int i = 0; i < n; i++)
			maxPrefix[i] = Math.max(paper[i], Math.max(hoof[i], scissors[i]));
		int[] paper2 = new int[n];
		int[] hoof2 = new int[n];
		int[] scissors2 = new int[n];
		int paperCnt2 = 0;
		for(int i = n - 1; i >= 0; i--) {
			if(moves[i] == 'H')
				++paperCnt2;
			paper2[i] = paperCnt2;
		}
		int hoofCnt2 = 0;
		for(int i = n - 1; i >= 0; i--) {
			if(moves[i] == 'S')
				++hoofCnt2;
			hoof2[i] = hoofCnt2;
		}
		int scissorsCnt2 = 0;
		for(int i = n - 1; i >= 0; i--) {
			if(moves[i] == 'P')
				++scissorsCnt2;
			scissors2[i] = scissorsCnt2;
		}
		int[] maxSuffix = new int[n];
		for(int i = 0; i < n; i++)
			maxSuffix[i] = Math.max(paper2[i], Math.max(hoof2[i], scissors2[i]));
		int ans = 0;
		for(int i = 0; i < n - 1; i++)
			ans = Math.max(ans, maxPrefix[i] + maxSuffix[i + 1]);
		System.out.println(ans);
		br.close();
	}
}