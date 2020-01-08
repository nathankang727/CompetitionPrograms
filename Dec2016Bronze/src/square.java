import java.util.*;
import java.io.*;
public class square {
    static BufferedReader br;
    static PrintWriter pw;
    static int x1, y1, x2, y2, x3, y3, x4, y4;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("square.in")));
            pw = new PrintWriter(new File("square.out"));
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
    	int minX = Math.min(x1, Math.min(x2, Math.min(x3, x4)));
    	int minY = Math.min(y1, Math.min(y2, Math.min(y3, y4)));
    	int maxX = Math.max(x1, Math.max(x2, Math.max(x3, x4)));
    	int maxY = Math.max(y1, Math.max(y2, Math.max(y3, y4)));
    	return String.valueOf((int)(Math.pow(Math.max(maxX - minX, maxY - minY), 2)));
    }
}