package Jan2018Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: lifeguards
*/
import java.util.*;
import java.io.*;
public class lifeguards {
    static BufferedReader br;
    static int n;
    static int[] start;
    static int[] end;
    static int[] times;
    static PrintWriter pw;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("lifeguards.in")));
            pw = new PrintWriter(new File("lifeguards.out"));
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
    	start = new int[n];
    	end = new int[n];
    	times = new int[1001];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		start[i] = Integer.parseInt(st.nextToken());
    		end[i] = Integer.parseInt(st.nextToken());
    	}
    	for(int i = 0; i < n; i++)
    		for(int j = start[i]; j < end[i]; j++)
    			++times[j];
    }
    private static String solve() {
    	int max = 0;
    	int[] duplicate = new int[1001];
    	for(int i = 0; i < 1001; i++)
    		duplicate[i] = times[i];
    	for(int i = 0; i < n; i++) {
    		int count = 0;
    		for(int j = start[i]; j < end[i]; j++)
    			--times[j];
    		for(int j = 0; j < 1001; j++)
    			if(times[j] > 0)
    				++count;
    		if(count > max)
    			max = count;
    		for(int j = 0; j < 1001; j++)
    			times[j] = duplicate[j];
    	}
        return String.valueOf(max);
    }
}