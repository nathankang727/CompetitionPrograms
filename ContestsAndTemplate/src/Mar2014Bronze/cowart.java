package Mar2014Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: cowart
*/
import java.io.*;
public class cowart {
    static BufferedReader br;
    static PrintWriter pw;
    static char[][] c;
    static boolean[][] b;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("cowart.in")));
            pw = new PrintWriter(new File("cowart.out"));
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
    	int n = Integer.parseInt(br.readLine());
    	c = new char[n][n];
    	b = new boolean[n][n];
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < n; j++)
    			c[i][j] = s.charAt(j);
    	}
    }
    private static String solve() {
        int human = 0;
        int cow = 0;
        String s = "RGB";
        for(int i = 0; i < 3; i++) {
        	for(int j = 0; j < c.length; j++) {
        		for(int k = 0; k < c.length; k++) {
        			int count = recursion(j, k, s.charAt(i));
        			if(count > 0)
        				++human;
        		}
        	}
        }
        for(int i = 0; i < c.length; i++)
        	for(int j = 0; j < c.length; j++)
        		if(c[i][j] == 'G')
        			c[i][j] = 'R';
        s = "RB";
        b = new boolean[c.length][c.length];
        for(int i = 0; i < 2; i++) {
        	for(int j = 0; j < c.length; j++) {
        		for(int k = 0; k < c.length; k++) {
        			int count = recursion(j, k, s.charAt(i));
        			if(count > 0)
        				++cow;
        		}
        	}
        }
    	return human + " " + cow;
    }
    public static int recursion (int x, int y, char t) {
		if(x < 0 || y < 0 || x >= c.length || y >= c.length)
			return 0;
		else if(c[x][y] != t || b[x][y])
			return 0;
		else {
			b[x][y] = true;
			return 1 + recursion(x + 1, y, t) + recursion(x, y + 1, t) + recursion(x - 1, y, t) + recursion(x, y - 1, t);
		}
	}
}