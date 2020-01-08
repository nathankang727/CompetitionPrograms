package Training1_3;
/*
ID: nathank3
LANG: JAVA
TASK: transform
*/
import java.util.*;
import java.io.*;
public class transform {
    static Scanner in;
    static PrintWriter out;
    static char[][] o;
    static char[][] n;
    static int num;
    public static void main(String[] args) {
        try {
            in = new Scanner(new File("transform.in"));
            out = new PrintWriter(new File("transform.out"));
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
    	num = Integer.parseInt(in.nextLine());
    	o = new char[num][num];
    	n = new char[num][num];
    	for(int i = 0; i < num; i++) {
    		String s = in.nextLine();
    		for(int j = 0; j < num; j++)
    			o[i][j] = s.charAt(j);
    	}
    	for(int i = 0; i < num; i++) {
    		String s = in.nextLine();
    		for(int j = 0; j < num; j++)
    			n[i][j] = s.charAt(j);
    	}
    }
    private static String solve() {
        int[] possible = {1, 2, 3, 4, 51, 52, 53, 6, 7};
        int res = 0;
        for(int i = 0; i < possible.length; i++) {
        	if(possible[i] == 1) {
        		if(debug(rotation(o)))
        			res = 1;
        	}
        	else if(possible[i] == 2) {
        		if(debug(rotation(rotation(o))))
        			res = 2;
        	}
        	else if(possible[i] == 3) {
        		if(debug(rotation(rotation(rotation(o)))))
        			res = 3;
        	}
            else if(possible[i] == 4) {
        		if(debug(reflection(o)))
        			res = 4;
            }
            else if(possible[i] == 51) {
        		if(debug(rotation(reflection(o))))
        			res = 5;
            }
            else if(possible[i] == 52) {
        		if(debug(rotation(rotation(reflection(o)))))
        			res = 5;
            }
        	else if(possible[i] == 53) {
        		if(debug(rotation(rotation(rotation(reflection(o))))))
        			res = 5;
        	}
            else if(possible[i] == 6) {
        		if(debug(o))
        			res = 6;
            }
        	else {
        		res = 7;
        	}
        	if(res != 0)
        		break;
        }
        return String.valueOf(res);
    }
    private static char[][] rotation(char[][] a) {
    	char[][] mod = new char[num][num];
    	int r1 = 0;
    	int c1 = 0;
    	for(int c = 0; c < num; c++) {
    		for(int r = num - 1; r >= 0; r--) {
    			mod[r1][c1] = a[r][c];
    			c1++;
    		}
    		c1 = 0;
    		r1++;
    	}
    	return mod;
    }
    private static char[][] reflection(char[][] a) {
    	char[][] mod = new char[num][num];
    	int r1 = 0;
    	int c1 = 0;
    	for(int r = 0; r < num; r++) {
    		for(int c = num - 1; c >= 0; c--) {
    			mod[r1][c1] = a[r][c];
    			c1++;
    		}
    		c1 = 0;
    		r1++;
    	}
    	return mod;
    }
    private static boolean debug(char[][] a) {
    	for(int i = 0; i < num; i++)
    		for(int j = 0; j < num; j++)
    			if(a[i][j] != n[i][j])
    				return false;
    	return true;
    }
}