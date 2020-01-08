package Mar2014Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: lazy
*/
import java.util.*;
import java.io.*;
public class lazy {
    static BufferedReader br;
    static PrintWriter pw;
    static int[] patches;
    static int n;
    static int k;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("lazy.in")));
            pw = new PrintWriter(new File("lazy.out"));
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
    	n = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	patches = new int[1000001];
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int patch = Integer.parseInt(st.nextToken());
    		patches[Integer.parseInt(st.nextToken())] = patch;
    	}
    }
    private static String solve() {
    	long max = 0;
    	if(k >= 1000001) {
    		max = 0;
    		for(int i = 0; i < patches.length; i++)
    			max += patches[i];
    	}
    	else {
    		for(int i = 0; i <= 2 * k; i++)
    			max += patches[i];
    		long count = max;
    		for(int i = 2 * k + 1; i < patches.length; i++) {
    			count -= patches[i - 2 * k - 1];
    			count += patches[i];
    			if(count > max)
    				max = count;
    		}
    	}
    	return String.valueOf(max);
    }
}