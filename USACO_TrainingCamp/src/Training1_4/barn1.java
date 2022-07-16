package Training1_4;
/*
ID: nathank3
LANG: JAVA
TASK: barn1
*/
import java.util.*;
import java.io.*;
public class barn1 {
    static Scanner in;
    static PrintWriter out;
    static int n;
    static int[] stalls;
    static ArrayList<Integer> diff;
    public static void main(String[] args) {
        try {
            in = new Scanner(new File("barn1.in"));
            out = new PrintWriter(new File("barn1.out"));
            init();
            out.println(solve());
            out.close();
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() {
    	n = in.nextInt();
    	in.nextInt();
    	int c = in.nextInt();
    	stalls = new int[c];
    	for(int i = 0; i < c; i++)
    		stalls[i] = in.nextInt();
    	Arrays.sort(stalls);
    	diff = new ArrayList<Integer>();
    }
    private static String solve() {
    	if(n == 1)
    		return stalls[stalls.length - 1] - stalls[0] + 1 + "";
    	else if(n >= stalls.length)
    		return stalls.length + "";
    	else {
    		for(int i = 0; i < stalls.length - 1; i++)
    			if(stalls[i + 1] - stalls[i] - 1 > 0)
    				diff.add(stalls[i + 1] - stalls[i] - 1);
    		int sum = 0;
    		Collections.sort(diff);
    		for(int i = 0; i < n - 1; i++)
    			sum += diff.remove(diff.size() - 1);
    		return stalls[stalls.length - 1] - stalls[0] + 1 - sum + "";
    	}
    }
}