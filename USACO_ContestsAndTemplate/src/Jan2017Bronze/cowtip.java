package Jan2017Bronze;
import java.io.*;
public class cowtip {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static boolean[][] grid;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("cowtip.in")));
            pw = new PrintWriter(new File("cowtip.out"));
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
    	grid = new boolean[n][n];
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < n; j++)
    			grid[i][j] = (s.charAt(j) == '0') ? true : false;
    	}
    }
    private static String solve() {
    	int result = 0;
    	for(int i = n - 1; i >= 0; i--) {
    		for(int j = n - 1; j >= 0; j--) {
    			if(!grid[i][j]) {
    				++result;
    				for(int r = 0; r <= i; r++)
    					for(int c = 0; c <= j; c++)
    						grid[r][c] = !grid[r][c];
    			}
    		}
    	}
        return String.valueOf(result);
    }
}