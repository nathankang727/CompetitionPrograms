package Jan2018Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: billboard2
*/
import java.util.*;
import java.io.*;
public class billboard2 {
    static BufferedReader br;
    static PrintWriter pw;
    static int x1;
    static int y1;
	static int x2;
	static int y2;
	static int x3;
	static int y3;
	static int x4;
	static int y4;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("billboard.in")));
            pw = new PrintWriter(new File("billboard.out"));
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
    	x1 = Integer.parseInt(st.nextToken());
    	y1 = Integer.parseInt(st.nextToken());
    	x2 = Integer.parseInt(st.nextToken());
    	y2 = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	x3 = Integer.parseInt(st.nextToken());
    	y3 = Integer.parseInt(st.nextToken());
    	x4 = Integer.parseInt(st.nextToken());
    	y4 = Integer.parseInt(st.nextToken());
    }
    private static String solve() {
    	int c = 0;
    	if(x1 >= x3 && x1 <= x4 && y1 >= y3 && y1 <= y4)
    		++c;
    	if(x1 >= x3 && x1 <= x4 && y2 >= y3 && y2 <= y4)
    		++c;
    	if(x2 >= x3 && x2 <= x4 && y1 >= y3 && y1 <= y4)
    		++c;
    	if(x2 >= x3 && x2 <= x4 && y2 >= y3 && y2 <= y4)
    		++c;
    	if(c < 2)
    		return String.valueOf((x2 - x1) * (y2 - y1));
    	else if(c == 2) {
    		int l = Math.max(x1, x3);
    		int r = Math.min(x2, x4);
    		int b = Math.max(y1, y3);
    		int t = Math.min(y2, y4);
    		return String.valueOf((x2 - x1) * (y2 - y1) - (r - l) * (t - b));
    	}
    	return "0";
    }
}