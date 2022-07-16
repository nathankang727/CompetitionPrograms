package Jan2019Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: sleepy
*/
import java.util.*;
import java.io.*;
public class sleepy {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] p;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("sleepy.in")));
            pw = new PrintWriter(new File("sleepy.out"));
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
    	p = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++)
    		p[i] = Integer.parseInt(st.nextToken());
    }
    private static String solve() {
    	int res = n - 1;
    	for(int i = n - 2; i >= 0; i--) {
    		if(p[i] <= p[i + 1])
    			res = i;
    		else
    			break;
    	}
    	return String.valueOf(res);
    }
}