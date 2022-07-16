package Training1_4;
/*
ID: nathank3
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;
public class wormhole {
    static BufferedReader in;
    static PrintWriter out;
    static int n;
    static int[] x;
    static int[] y;
    static int[] partner;
    static int[] next;
    public static void main(String[] args) {
        try {
            in = new BufferedReader(new FileReader(new File("wormhole.in")));
            out = new PrintWriter(new File("wormhole.out"));
            init();
            out.println(solve());
            out.close();
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	n = Integer.parseInt(in.readLine());
    	x = new int[n + 1];
    	y = new int[n + 1];
    	for(int i = 1; i <= n; i++) {
    		StringTokenizer st = new StringTokenizer(in.readLine());
    		x[i] = Integer.parseInt(st.nextToken());
    		y[i] = Integer.parseInt(st.nextToken());
    	}
    	partner = new int[n + 1];
    	next = new int[n + 1];
    	for(int i = 1; i <= n; i++)
    		for(int j = 1; j <= n; j++)
    			if(x[j] > x[i] && y[i] == y[j])
    				if(next[i] == 0 || x[j] - x[i] < x[next[i]] - x[i])
    					next[i] = j;
    }
    private static String solve() {
        return String.valueOf(recursion());
    }
    private static int recursion() {
    	int total = 0;
    	int i = 0;
    	for(i = 1; i <= n; i++) {
        	//first unpaired wormhole
        	if(partner[i] == 0)
        		break;
    	}
    	//base case
        if(i > n) {
        	if(cycle())
        		return 1;
        	else
        		return 0;
        }
        //pair i with possible j
        for(int j = i + 1; j <= n; j++) {
        	if(partner[j] == 0) {
        		//try to pair i & j, use recursion to find rest of solution
        		partner[i] = j;
        		partner[j] = i;
        		total += recursion();
        		partner[i] = 0;
        		partner[j] = 0;
        	}
        }
    	return total;
    }
    private static boolean cycle() {
    	for(int i = 1; i <= n; i++) {
    		//cycle exists?
    		int position = i;
    		for(int j = 1; j <= n; j++)
    			position = next[partner[position]];
    		if(position != 0)
    			return true;
    	}
    	return false;
    }
}