package Training1_2;
/*
ID: nathank3
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;
public class beads {
    static Scanner in;
    static PrintWriter out;
    static int n;
    static String s;
    public static void main(String[] args) {
        try {
            in = new Scanner(new File("beads.in"));
            out = new PrintWriter(new File("beads.out"));
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
    	n = Integer.parseInt(in.nextLine());
    	s = in.nextLine();
    	s += s;
    }
    private static String solve() {
    	int res = 0;
        for(int i = 0; i < s.length() / 2; i++) {
        	char start = s.charAt(i);
        	int n = 0;
        	if(start == 'w')
        		n = Math.max(method('r', i), method('b', i));
        	else
        		n = method(start, i);
        	if(n > res)
        		res = n;
        }
        if(res > n)
        	res = n;
        return String.valueOf(res);
    }
    private static int method(char start, int i) {
    	boolean b = true;
    	int count = 0;
    	for(int j = 0; j < n; j++) {
    		char c = s.charAt(j + i);
    		if(b) {
    			if(c != start && c != 'w')
    				b = false;
    			count++;
    		}
    		else {
    			if(c == start)
    				break;
    			count++;
    		}
    	}
    	System.out.println(start);
    	System.out.println(count + " " + i);
    	return count;
    }
}