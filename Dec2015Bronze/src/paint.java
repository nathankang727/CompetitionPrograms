import java.util.*;
import java.io.*;
public class paint {
    static BufferedReader br;
    static PrintWriter pw;
    static int a, b, c, d;
    static boolean[] fence;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("paint.in")));
            pw = new PrintWriter(new File("paint.out"));
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
    	a = Integer.parseInt(st.nextToken());
    	b = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	c = Integer.parseInt(st.nextToken());
    	d = Integer.parseInt(st.nextToken());
    	fence = new boolean[101];
    	for(int i = a; i < b; i++)
    		fence[i] = true;
    	for(int i = c; i < d; i++)
    		fence[i] = true;
    }
    private static String solve() {
        int count = 0;
    	for(int i = 0; i < 101; i++)
        	if(fence[i])
        		++count;
    	return String.valueOf(count);
    }
}