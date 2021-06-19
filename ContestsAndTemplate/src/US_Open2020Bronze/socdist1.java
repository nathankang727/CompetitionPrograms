package US_Open2020Bronze;
import java.util.*;
import java.io.*;
public class socdist1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("socdist1.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("socdist1.out")));
		int n = Integer.parseInt(br.readLine());
		boolean[] stalls = new boolean[n];
		String input = br.readLine();
		for(int i = 0; i < n; i++)
			stalls[i] = input.charAt(i) == '1';
		ArrayList<Integer> distances = new ArrayList<Integer>();
		int start1 = -1;
		int minDistance = n;
		for(int i = 0; i < n; i++) {
			if(stalls[i]) {
				if(start1 > -1) {
					distances.add(i - start1);
					minDistance = Math.min(minDistance, i - start1);
				}
				start1 = i;
			}
		}
		if(start1 == -1)
			pw.println(n - 1);
		else if(start1 != -1 && distances.size() == 0) {
			if(start1 == 0 || start1 == n - 1)
				pw.println((n - 1) / 2);
			else {
				int max = Math.max(start1, n - start1 - 1);
				int min = Math.min(start1, n - start1 - 1);
				pw.println(Math.max(min, (max - 1) / 2));
			}
		}
		else {
			int indexEnd = n - 1;
			while(!stalls[indexEnd])
				--indexEnd;
			int indexStart = 0;
			while(!stalls[indexStart])
				++indexStart;
			Collections.sort(distances);
			int distancesLast = distances.get(distances.size() - 1) / 3;
			if(n - 1 - indexEnd >= minDistance && indexStart >= minDistance)
				pw.println(distances.get(0));
			else if(n - 1 - indexEnd >= minDistance || indexStart >= minDistance) {
				distances.set(distances.size() - 1, distances.get(distances.size() - 1) / 2);
				Collections.sort(distances);
				pw.println(Math.min(minDistance, distances.get(0)));
			}
			else {
				for(int i = 0; i < 2; i++) {
					distances.set(distances.size() - 1, distances.get(distances.size() - 1) / 2);
					Collections.sort(distances);
				}
				pw.println(Math.min(minDistance, Math.max(distances.get(0), distancesLast)));
			}
		}
		br.close();
		pw.close();
	}
}