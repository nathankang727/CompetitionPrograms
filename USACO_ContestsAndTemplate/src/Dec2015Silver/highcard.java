package Dec2015Silver;
import java.util.*;
import java.io.*;
public class highcard {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("highcard.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("highcard.out")));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> elsie = new ArrayList<Integer>();
		ArrayList<Integer> bessie = new ArrayList<Integer>();
		boolean[] input = new boolean[2 * n + 1];
		for(int i = 0; i < n; i++)
			input[Integer.parseInt(br.readLine())] = true;
		for(int i = 1; i <= 2 * n; i++) {
			if(input[i])
				elsie.add(i);
			else
				bessie.add(i);
		}
		Collections.sort(elsie);
		Collections.sort(bessie);
		int cnt = 0;
		int eCount = 0;
		int bCount = 0;
		while(eCount < n && bCount < n) {
			if(bessie.get(bCount) > elsie.get(eCount)) {
				++cnt;
				++eCount;
			}				
			++bCount;
		}
		pw.println(cnt);
		br.close();
		pw.close();
	}
}