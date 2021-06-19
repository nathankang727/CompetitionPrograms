package Mar2014Bronze;
import java.io.*;
public class cowart {
    static char[][] c;
    static boolean[][] b;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("cowart.in")));
        PrintWriter pw = new PrintWriter(new File("cowart.out"));
        int n = Integer.parseInt(br.readLine());
    	c = new char[n][n];
    	b = new boolean[n][n];
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < n; j++)
    			c[i][j] = s.charAt(j);
    	}
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
    	pw.println(human + " " + cow);
        br.close();
        pw.close();
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