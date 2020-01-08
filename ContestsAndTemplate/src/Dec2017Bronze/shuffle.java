package Dec2017Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: shuffle
*/
import java.util.*;
import java.io.*;
public class shuffle {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] swap;
    static int[] cows;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("shuffle.in")));
            pw = new PrintWriter(new File("shuffle.out"));
            init();
            pw.print(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	n = Integer.parseInt(br.readLine());
    	swap = new int[n + 1];
    	cows = new int[n + 1];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		int temp = Integer.parseInt(st.nextToken());
    		swap[temp] = i;
    	}
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++)
    		cows[i] = Integer.parseInt(st.nextToken());
    }
    private static String solve() {
    	String res = "";
    	int[] original = new int[n + 1];
    	for(int i = 1; i <= n; i++) {
    		int current = i;
    		for(int j = 0; j < 3; j++)
    			current = swap[current];
    		original[current] = cows[i];
    	}
    	for(int i = 1; i <= n; i++)
    		res += original[i] + "\n";
    	return res;
    }
}