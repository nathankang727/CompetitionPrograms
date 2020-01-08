package Training1_3;
/*
ID: nathank3
LANG: JAVA
TASK: milk2
*/
import java.util.*;
import java.io.*;
public class milk2 {
    static Scanner in;
    static PrintWriter out;
    static Time[] times;
    public static void main(String[] args) {
        try {
            in = new Scanner(new File("milk2.in"));
            out = new PrintWriter(new File("milk2.out"));
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
    	int n = in.nextInt();
    	times = new Time[n];
    	for(int i = 0; i < n; i++)
    		times[i] = new Time(in.nextInt(), in.nextInt());
    	Arrays.sort(times);
    }
    private static String solve() {
    	int start = times[0].getStart();
    	int end = times[0].getEnd();
    	int milking = 0;
    	int stop = 0;
    	int maxMilking = 0;
    	int maxStop = 0;
    	for(int i = 1; i < times.length; i++) {
    		int cs = times[i].getStart();
    		int ce = times[i].getEnd();
    		if(ce <= end)
    			continue;
    		else if(cs <= end && ce > end)
    			end = ce;
    		else if(cs > end && ce > end) {
    			stop = cs - end;
    			if(stop > maxStop)
    				maxStop = stop;
    			milking = end - start;
    			if(milking > maxMilking)
    				maxMilking = milking;
    			start = cs;
    			end = ce;
    		}
    	}
    	milking = end - start;
    	if(milking > maxMilking)
    		maxMilking = milking;
    	return maxMilking + " " + maxStop;
    }
}
class Time implements Comparable<Time> {
    private int start;
    private int end;
    public int compareTo(Time t) { 
        return this.start - t.start; 
    } 
    public Time(int st, int en) {
        this.start = st; 
        this.end = en; 
    } 
    public int getStart() {
    	return start;
    }
    public int getEnd() {
    	return end;
    }
}