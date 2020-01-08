package Jan2016Bronze;
import java.util.*;
import java.io.*;
public class mowing {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[][] grid;
    static char[] direction;
    static int[] movement;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("mowing.in")));
            pw = new PrintWriter(new File("mowing.out"));
            init();
            pw.println(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	n = Integer.parseInt(br.readLine());
    	grid = new int[2001][2001];
    	for(int i = 0; i < 2001; i++)
    		for(int j = 0; j < 2001; j++)
    			grid[i][j] = -1;
    	direction = new char[n];
    	movement = new int[n];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		direction[i] = st.nextToken().charAt(0);
    		movement[i] = Integer.parseInt(st.nextToken());
    	}
    }
    private static String solve() {
    	int pointX = 1000;
    	int pointY = 1000;
    	grid[pointX][pointY] = 0;
    	int res = 1001;
    	int time = 0;
    	for(int i = 0; i < n; i++) {
    		char c = direction[i];
    		int leftOrRight = 0;
    		int downOrUp = 0;
    		if(c == 'W')
    			downOrUp = -1;
    		else if(c == 'E')
    			downOrUp = 1;
    		else if(c == 'N')
    			leftOrRight = -1;
    		else
    			leftOrRight = 1;
    		int num = movement[i];
    		for(int j = 0; j < num; j++) {
    			pointX += leftOrRight;
    			pointY += downOrUp;
    			++time;
    			if(grid[pointX][pointY] >= 0 && time - grid[pointX][pointY] < res)
    				res = time - grid[pointX][pointY];
    			grid[pointX][pointY] = time;
    		}
    	}
    	if(res > 1000)
    		res = -1;
        return String.valueOf(res);
    }
}