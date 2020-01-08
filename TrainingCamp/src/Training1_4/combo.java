package Training1_4;
/*
ID: nathank3
LANG: JAVA
TASK: combo
*/
import java.util.*;
import java.io.*;
public class combo {
    static BufferedReader in;
    static PrintWriter out;
    static int n;
    static int[] combo1;
    static int[] combo2;
    public static void main(String[] args) {
        try {
            in = new BufferedReader(new FileReader(new File("combo.in")));
            out = new PrintWriter(new File("combo.out"));
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
    	StringTokenizer st = new StringTokenizer(in.readLine());
   		combo1 = new int[3];
   		combo2 = new int[3];
    	for(int i = 0; i < 3; i++)
   			combo1[i] = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(in.readLine());
    	for(int i = 0; i < 3; i++)
    		combo2[i] = Integer.parseInt(st.nextToken());
    }
    private static String solve() {
    	int[] possible = {-2, -1, 0, 1, 2};
        Set<String> res = new HashSet<String>();
        for(int i = 0; i < 5; i++) {
        	for(int j = 0; j < 5; j++) {
        		for(int k = 0; k < 5; k++) {
        			res.add((combo1[0] + possible[i] + n) % n + " " + (combo1[1] + possible[j] + n) % n + " " + 
        					(combo1[2] + possible[k] + n) % n);
        			res.add((combo2[0] + possible[i] + n) % n + " " + (combo2[1] + possible[j] + n) % n + " " + 
        					(combo2[2] + possible[k] + n) % n);
        		}
        	}
        }
        for(String s: res)
        	System.out.println(s);
    	return String.valueOf(res.size());
    }
}