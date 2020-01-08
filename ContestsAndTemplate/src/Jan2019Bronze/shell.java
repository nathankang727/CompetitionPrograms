package Jan2019Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: shell
*/
import java.util.*;
import java.io.*;
public class shell {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[][] abg;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("shell.in")));
            pw = new PrintWriter(new File("shell.out"));
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
    	abg = new int[n][3];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		abg[i][0] = Integer.parseInt(st.nextToken());
    		abg[i][1] = Integer.parseInt(st.nextToken());
    		abg[i][2] = Integer.parseInt(st.nextToken());
    	}
    }
    private static String solve() {
    	int max = 0;
    	boolean[] b = new boolean[3];
    	for(int i = 0; i < 3; i++) {
    		b = new boolean[3];
    		b[i] = true;
    		int count = 0;
    		for(int j = 0; j < n; j++) {
    			boolean temp = b[abg[j][0] - 1];
    			b[abg[j][0] - 1] = b[abg[j][1] - 1];
    			b[abg[j][1] - 1] = temp;
    			if(b[abg[j][2] - 1])
    				++count;
    		}
    		if(count > max)
    			max = count;
    	}
        return String.valueOf(max);
    }
}