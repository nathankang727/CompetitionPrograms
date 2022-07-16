import java.io.*;
public class div7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] firstOccurence = new int[7];
		for(int i = 0; i < 7; i++)
			firstOccurence[i] = Integer.MAX_VALUE;
		boolean[] firstFound = new boolean[7];
		int[] lastOccurence = new int[7];
		boolean[] lastFound = new boolean[7];
		long prefixSum = 0;
		int[] modded = new int[n];
		for(int i = 0; i < n; i++) {
			prefixSum += Long.parseLong(br.readLine());
			modded[i] = (int)(prefixSum % (long)(7));
		}
		for(int i = 0; i < n; i++) {
			if(!firstFound[modded[i]]) {
				firstFound[modded[i]] = true;
				firstOccurence[modded[i]] = i;
			}
		}
		for(int i = n - 1; i >= 0; i--) {
			if(!lastFound[modded[i]]) {
				lastFound[modded[i]] = true;
				lastOccurence[modded[i]] = i;
			}
		}
		int answer = 0;
		for(int i = 0; i < 7; i++)
			answer = Math.max(answer, lastOccurence[i] - firstOccurence[i]);
		System.out.println(answer);
		br.close();
	}
}