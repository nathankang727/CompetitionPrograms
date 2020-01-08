package Dec2019Bronze;
import java.util.*;
import java.io.*;
public class gymnastics {
    static BufferedReader br;
    static PrintWriter pw;
    static int k, n;
    static int[][] rank;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("gymnastics.in")));
            pw = new PrintWriter(new File("gymnastics.out"));
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
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	k = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	rank = new int[k][n];
    	for(int i = 0; i < k; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++)
    			rank[i][j] = Integer.parseInt(st.nextToken());
    	}
    }
    private static String solve() {
    	int result = 0;
    	for(int i = 1; i <= n; i++) {
    		for(int j = i + 1; j <= n; j++) {
    			boolean b1 = better(i, j, 0);
    			boolean b2 = false;
    			for(int k1 = 0; k1 < k; k1++) {
    				if(better(i, j, k1) != b1) {
    					b2 = true;
    					break;
    				}
    			}
    			if(!b2)
    				++result;
    		}
    	}
        return result + "";
    }
    private static boolean better(int num1, int num2, int num3) {
    	boolean b = false;
    	for(int i = 0; i < n; i++) {
    		if(rank[num3][i] == num1) {
    			b = true;
    			break;
    		}
    		if(rank[num3][i] == num2)
    			break;
    	}
    	return b;
    }
}