package Dec2020Silver;
import java.util.*;
import java.io.*;
public class StuckInARut_Silver {
	static int n;
	static ArrayList<eastCows> east;
	static ArrayList<northCows> north;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		east = new ArrayList<eastCows>();
		north = new ArrayList<northCows>();
		int[] answers = new int[n];
		boolean[] stapped = new boolean[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int input1 = Integer.parseInt(st.nextToken());
			int input2 = Integer.parseInt(st.nextToken());
			if(c == 'E')
				east.add(new eastCows(i, input1, input2));
			else
				north.add(new northCows(i, input1, input2));
		}
		Collections.sort(east);
		Collections.sort(north);
		for(int i = 0; i < east.size(); i++) {
			for(int j = 0; j < north.size(); j++) {
				if(!stapped[east.get(i).i] && !stapped[north.get(j).i] && east.get(i).x < north.get(j).x && east.get(i).y > north.get(j).y) {
					if(north.get(j).x - east.get(i).x > east.get(i).y - north.get(j).y) {
						stapped[east.get(i).i] = true;
						answers[north.get(j).i] += answers[east.get(i).i] + 1;
					}
					else if(north.get(j).x - east.get(i).x < east.get(i).y - north.get(j).y) {
						stapped[north.get(j).i] = true;
						answers[east.get(i).i] += answers[north.get(j).i] + 1;
					}
				}
			}
		}
		for(int i = 0; i < n; i++)
			System.out.println(answers[i]);
		br.close();
	}
	static class eastCows implements Comparable<eastCows> {
		public int i, x, y;
		public int compareTo(eastCows ec) {
			return this.y - ec.y;
		}
		public eastCows(int index, int horizontal, int vertical) {
			this.i = index;
			this.x = horizontal;
			this.y = vertical;
		}
	}
	static class northCows implements Comparable<northCows> {
		public int i, x, y;
		public int compareTo(northCows nc) {
			return this.x - nc.x;
		}
		public northCows(int index, int horizontal, int vertical) {
			this.i = index;
			this.x = horizontal;
			this.y = vertical;
		}
	}
}