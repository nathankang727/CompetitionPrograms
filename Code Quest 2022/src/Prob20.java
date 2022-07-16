import java.util.*;
public class Prob20 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int x = sc.nextInt();
			int[][] board = new int[x + 1][];
			for(int j = 0; j < x + 1; j++) {
				board[j] = new int[j + 1];
				for(int k = 0; k < j + 1; k++)
					board[j][k] = sc.nextInt();
			}
			Queue<Path> q = new LinkedList<Path>();
			q.add(new Path("", board[0][0]));
			Path max = new Path("", Integer.MIN_VALUE);
			while(!q.isEmpty()) {
				Path top = q.remove();
				if(top.pa.length() == x) {
					if(top.pt > max.pt)
						max = new Path(top.pa, top.pt);
					continue;
				}
				int rCnt = 0;
				for(int j = 0; j < top.pa.length(); j++)
					if(top.pa.charAt(j) == 'R')
						++rCnt;
				String pathL = top.pa + "L";
				int ptL = top.pt + board[top.pa.length() + 1][rCnt];
				q.add(new Path(pathL, ptL));
				String pathR = top.pa + "R";
				int ptR = top.pt + board[top.pa.length() + 1][rCnt + 1];
				q.add(new Path(pathR, ptR));
			}
			System.out.println(max.pa + " = " + max.pt);
		}
		sc.close();
	}
	static class Path {
		public String pa;
		public int pt;
		public Path(String path, int points) {
			pa = path;
			pt = points;
		}
	}
}