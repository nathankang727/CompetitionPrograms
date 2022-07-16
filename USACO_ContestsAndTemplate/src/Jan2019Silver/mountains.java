package Jan2019Silver;
import java.util.*;
import java.io.*;
public class mountains {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static Mountain[] values;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("mountains.in")));
            pw = new PrintWriter(new File("mountains.out"));
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
    	values = new Mountain[n];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		values[i] = new Mountain(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    	}
    	Arrays.sort(values);
    }
    private static String solve() {
    	int count = 0;
    	for(int i = 0; i < n; i++) {
    		boolean didBreak = false;
    		for(int j = i + 1; j < n; j++) {
    			if(i == j)
    				continue;
    			int addend1 = values[j].getY() - values[j].getX();
    			int addend2 = values[j].getY() + values[j].getX();
    			if(values[i].getY() <= values[i].getX() + addend1 && values[i].getY() <= -values[i].getX() + addend2) {
    				didBreak = true;
    				break;
    			}
    		}
    		if(!didBreak)
    			++count;
    	}
        return String.valueOf(count);
    }
}
class Mountain implements Comparable<Mountain> {
    private int x;
    private int y;
    public int compareTo(Mountain m) {
        return this.y - m.y;
    }
    public Mountain(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }
    public int getX() {
    	return x;
    }
    public int getY() {
    	return y;
    }
}