package Jan2018Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: outofplace
*/
import java.io.*;
import java.util.Arrays;
public class outofplace {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] cows;
    static int[] sort;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("outofplace.in")));
            pw = new PrintWriter(new File("outofplace.out"));
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
    	cows = new int[n];
    	sort = new int[n];
    	for(int i = 0; i < n; i++) {
    		cows[i] = Integer.parseInt(br.readLine());
    		sort[i] = cows[i];
    	}
    	Arrays.sort(sort);
    }
    private static String solve() {
    	int count = 0;
    	for(int i = 0; i < n; i++)
    		if(cows[i] != sort[i])
    			++count;
    	--count;
        return String.valueOf(count);
    }
}