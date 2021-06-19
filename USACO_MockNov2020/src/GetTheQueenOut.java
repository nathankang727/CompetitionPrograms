import java.util.*;
import java.io.*;
public class GetTheQueenOut {
	static int n, m;
    static int[][] maze;
    static Queue<Integer> q;
    static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
	static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	int x = 0;
    	int y = 0;
    	maze = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < m; j++) {
    			char sub = s.charAt(j);
    			if(sub == 'X')
    				maze[i][j] = 0;
    			else {
    				if(sub == 'Q') {
    					x = i;
    					y = j;
    				}
    				maze[i][j] = 1;
    			}
    		}
    	}
        if(x == 0 && y == 0 || x == 0 && y == m - 1 || x == n - 1 && y == 0 || x == n - 1 && y == m - 1)
        	System.out.println("0");
        else if(maze[0][0] == 0 && maze[0][m - 1] == 0 && maze[n - 1][0] == 0 && maze[n - 1][m - 1] == 0)
        	System.out.println("-1");
        else
        	System.out.println(bfs(x, y));
//        for(int i = 0; i < n; i++)
//        	System.out.println(Arrays.toString(maze[i]));
    	br.close();
    }
    public static int bfs(int x, int y) {
    	q = new LinkedList<Integer>();
    	q.add(x);
    	q.add(y);
    	q.add(-1);
    	maze[x][y] = 2;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	while(!q.isEmpty()) {
    		x = q.poll();
    		y = q.poll();
        	int previousDirection = q.poll();
//        	System.out.println(x + " " + y + " " + previousDirection);
    		for(int i = 0; i < 8; i++) {
    			int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= n || yy < 0 || yy >= m || maze[x][y] >= maze[xx][yy] && maze[xx][yy] != 1)
                	continue;
                q.add(xx);
                q.add(yy);
                q.add(i);
                if(previousDirection == -1 || previousDirection == i)
                	maze[xx][yy] = maze[x][y];
                else
                	maze[xx][yy] = maze[x][y] + 1;
                if(xx == 0 && yy == 0 || xx == 0 && yy == m - 1 || xx == n - 1 && yy == 0 || xx == n - 1 && yy == m - 1)
                	list.add(maze[xx][yy] - 1);
            }
    	}
    	Collections.sort(list);
//    	System.out.println(list.toString());
    	return list.get(0);
    }
}