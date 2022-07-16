import java.util.*;
import java.io.*;
public class planting {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Rect[] r = new Rect[n];
		int area = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			r[i] = new Rect(a, b, c, d);
		}
		ArrayList<Integer>[] subsets = new ArrayList[(int)(Math.pow(2, n)) - 1];
		for(int i = 1; i < Math.pow(2, n); i++) {
			subsets[i - 1] = new ArrayList<Integer>();
			String binary = Integer.toString(i, 2);
			int index = 0;
			for(int j = binary.length() - 1; j >= 0; j--) {
				if(binary.charAt(j) == '1')
					subsets[i - 1].add(index);
				++index;
			}
		}
		Arrays.sort(subsets, new Comparator<ArrayList<Integer>>() {
			 public int compare(ArrayList<Integer> al1, ArrayList<Integer> al2) {
			        if (al1.size() > al2.size())
			            return 1;
			        if (al1.size() < al2.size())
			            return -1;
			        return 0;
			    }
		});
		for(ArrayList<Integer> i : subsets) {
			int minX = r[i.get(0)].x2;
			int maxX = r[i.get(0)].x1;
			int minY = r[i.get(0)].y1;
			int maxY = r[i.get(0)].y2;
			for(int j = 1; j < i.size(); j++) {
				minX = Math.min(minX, r[i.get(j)].x2);
				maxX = Math.max(maxX, r[i.get(j)].x1);
				minY = Math.min(minY, r[i.get(j)].y1);
				maxY = Math.max(maxY, r[i.get(j)].y2);
			}
			int xDist = minX - maxX < 0 ? 0 : minX - maxX;
			int yDist = minY - maxY < 0 ? 0 : minY - maxY;
			if(i.size() % 2 == 1) {
				area += xDist * yDist;
			}
			else {
				area -= xDist * yDist;
			}
		}
		System.out.println(area);
		br.close();
	}
	static class Rect {
		public int x1, y1, x2, y2;
		public Rect(int xx1, int yy1, int xx2, int yy2) {
			this.x1 = xx1;
			this.y1 = yy1;
			this.x2 = xx2;
			this.y2 = yy2;
		}
	}
}