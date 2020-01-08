package Dec2018Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: blist
*/
import java.util.*;
import java.io.*;
public class blist {
    static BufferedReader br;
    static PrintWriter pw;
    static int[] timeline = new int[1001];
    static int n;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("blist.in")));
            pw = new PrintWriter(new File("blist.out"));
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
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int ends = Integer.parseInt(st.nextToken());
    		int buckets = Integer.parseInt(st.nextToken());
    		for(int j = start; j <= ends; j++)
    			timeline[j] += buckets;
    	}
    }
    private static String solve() {
        Arrays.sort(timeline);
        return String.valueOf(timeline[1000]);
    }
}