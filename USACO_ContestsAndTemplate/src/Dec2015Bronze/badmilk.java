package Dec2015Bronze;
import java.util.*;
import java.io.*;
public class badmilk {
    static BufferedReader br;
    static PrintWriter pw;
    static int n, m, d, s;
    static int[] person, milk, time, sickP, sickT;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("badmilk.in")));
            pw = new PrintWriter(new File("badmilk.out"));
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
    	m = Integer.parseInt(st.nextToken());
    	d = Integer.parseInt(st.nextToken());
    	s = Integer.parseInt(st.nextToken());
    	person = new int[d];
    	milk = new int[d];
    	time = new int[d];
    	for(int i = 0; i < d; i++) {
    		st = new StringTokenizer(br.readLine());
    		person[i] = Integer.parseInt(st.nextToken());
    		milk[i] = Integer.parseInt(st.nextToken());
    		time[i] = Integer.parseInt(st.nextToken());
    	}
    	sickP = new int[s];
    	sickT = new int[s];
    	for(int i = 0; i < s; i++) {
    		st = new StringTokenizer(br.readLine());
    		sickP[i] = Integer.parseInt(st.nextToken());
    		sickT[i] = Integer.parseInt(st.nextToken());
    	}
    }
    private static String solve() {
        int max = 0;
        for(int i = 1; i <= m; i++) {
        	if(bad(i)) {
        		int num = people(i);
        		if(num > max)
        			max = num;
        	}
        }
    	return String.valueOf(max);
    }
    private static boolean bad(int num) {
    	for(int i = 0; i < s; i++)
    		if(!before(sickP[i], sickT[i], num))
    			return false;
    	return true;
    }
    private static boolean before(int p, int t, int num) {
    	for(int i = 0; i < d; i++)
    		if(person[i] == p && milk[i] == num && time[i] < t)
    			return true;
    	return false;
    }
    private static int people(int num) {
    	int count = 0;
    	boolean[] b = new boolean[d];
    	for(int i = 0; i < d; i++)
    		if(milk[i] == num)
    			b[person[i]] = true;
    	for(int i = 0; i < d; i++)
    		if(b[i])
    			++count;
    	return count;
    }
}