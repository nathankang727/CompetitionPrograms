package Training1_2;
/*
ID: nathank3
LANG: JAVA
TASK: friday
*/
import java.util.*;
import java.io.*;
public class friday {
    static Scanner in;
    static PrintWriter out;
    //Input Variables
    static int n;
    static int[] regular = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int[] leap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int[] days;
    public static void main(String[] args) {
        try {
        	//Initialize in & out
            in = new Scanner(new File("friday.in"));
            out = new PrintWriter(new File("friday.out"));
            init();
            //Write out file
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
    	days = new int[7];
    }
    private static String solve() {
        int end = (n - 1) + 1900;
        int c = 0;
        for(int i = 1900; i <= end; i++) {
        	for(int j = 0; j <= 11; j++) {
        		int day = (c + 12) % 7;
        		days[day]++;
        		if(isLeap(i))
        			c += leap[j];
        		else
        			c += regular[j];
        	}
        }
        return (days[5] + " " + days[6] + " " + days[0] + " " + days[1] + " " + days[2] + " " + days[3] + " " + days[4]);
    }
    //Algorithm methods
    private static boolean isLeap(int year) {
    	if(year % 4 == 0) {
    		if(year % 100 == 0) {
    			if(year % 400 == 0)
    				return true;
    			return false;
    		}
    		return true;
    	}
    	return false;
    }
}