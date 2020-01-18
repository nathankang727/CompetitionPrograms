package Jan2017Silver;
import java.util.*;
import java.io.*;
public class cowdance {
    static BufferedReader br;
    static PrintWriter pw;
    static int n, tmax;
    static int[] nums;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("cowdance.in")));
            pw = new PrintWriter(new File("cowdance.out"));
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
    	tmax = Integer.parseInt(st.nextToken());
    	nums = new int[n];
    	for(int i = 0; i < n; i++)
    		nums[i] = Integer.parseInt(br.readLine());
    }
    private static String solve() {
    	
        return "";
    }
}