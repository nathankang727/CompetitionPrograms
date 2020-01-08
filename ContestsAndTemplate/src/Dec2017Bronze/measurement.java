package Dec2017Bronze;
import java.util.*;
import java.io.*;
public class measurement {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static M[] commands;
    static int[] production = {7, 7, 7};
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("measurement.in")));
            pw = new PrintWriter(new File("measurement.out"));
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
    	commands = new M[n];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int day = Integer.parseInt(st.nextToken());
    		int index = 0;
    		int change = 0;
    		String name = st.nextToken();
    		String cha = st.nextToken();
    		if(name.equals("Elsie"))
    			index = 1;
    		else if(name.equals("Mildred"))
    			index = 2;
    		if(cha.substring(0, 1).equals("+"))
    			change = Integer.parseInt(cha.substring(1));
    		else
    			change = Integer.parseInt(cha.substring(1)) * -1;
    		commands[i] = new M(day, index, change);
    	}
    	Arrays.sort(commands);
    }
    private static String solve() {
        int count = 0;
        boolean[] isLeader = {false, false, false};
        String s = Arrays.toString(isLeader);
    	for(int i = 0; i < n; i++) {
        	production[commands[i].getIndex()] += commands[i].getChange();
        	int max = Math.max(production[0], Math.max(production[1], production[2]));
        	for(int j = 0; j < 3; j++) {
        		if(production[j] == max)
        			isLeader[j] = true;
        		else
        			isLeader[j] = false;
        	}
        	if(!Arrays.toString(isLeader).equals(s))
        		++count;
    		s = Arrays.toString(isLeader);
    		isLeader = new boolean[3];
        }
    	return String.valueOf(count);
    }
}
class M implements Comparable<M> {
    private int day;
    private int index;
    private int change;
    public int compareTo(M m) {
        return this.day - m.day;
    }
    public M(int da, int in, int ch) {
        this.day = da;
        this.index = in;
        this.change = ch;
    }
    public int getDay() {
    	return day;
    }
    public int getIndex() {
    	return index;
    }
    public int getChange() {
    	return change;
    }
}