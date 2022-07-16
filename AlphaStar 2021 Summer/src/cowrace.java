import java.util.*;
import java.io.*;
public class cowrace {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> bessie = new ArrayList<Integer>();
		int bessieSum = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int speed = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			for(int j = 0; j < time; j++) {
				bessieSum += speed;
				bessie.add(bessieSum);
			}
		}
		ArrayList<Integer> elsie = new ArrayList<Integer>();
		int elsieSum = 0;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int speed = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			for(int j = 0; j < time; j++) {
				elsieSum += speed;
				elsie.add(elsieSum);
			}
		}
		int ahead = 0;
		int changeCount = 0;
		for(int i = 0; i < bessie.size(); i++) {
			if(bessie.get(i) > elsie.get(i) && ahead != 1) {
				++changeCount;
				ahead = 1;
			}
			else if(bessie.get(i) < elsie.get(i) && ahead != -1) {
				++changeCount;
				ahead = -1;
			}
		}
		System.out.println(changeCount - 1 == -1 ? 0 : changeCount - 1);
		br.close();
	}
}