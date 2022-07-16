package Dec2017Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: billboard
*/
import java.util.*;
import java.io.*;
public class billboard {
    static BufferedReader br;
    static PrintWriter pw;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("billboard.in")));
            pw = new PrintWriter(new File("billboard.out"));
            pw.println(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static String solve() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int x1 = Integer.parseInt(st.nextToken());
    	int y1 = Integer.parseInt(st.nextToken());
    	int x2 = Integer.parseInt(st.nextToken());
    	int y2 = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	int x3 = Integer.parseInt(st.nextToken());
    	int y3 = Integer.parseInt(st.nextToken());
    	int x4 = Integer.parseInt(st.nextToken());
    	int y4 = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	int x5 = Integer.parseInt(st.nextToken());
    	int y5 = Integer.parseInt(st.nextToken());
    	int x6 = Integer.parseInt(st.nextToken());
    	int y6 = Integer.parseInt(st.nextToken());
    	int sumArea = calculateArea(x1, y1, x2, y2, x5, y5, x6, y6) + calculateArea(x3, y3, x4, y4, x5, y5, x6, y6);
        return String.valueOf(sumArea);
    }
    private static int calculateArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
    	int area = (x2 - x1) * (y2 - y1);
    	int minX = Math.max(x1, x3);
    	int maxX = Math.min(x2, x4);
    	int minY = Math.max(y1, y3);
    	int maxY = Math.min(y2, y4);
    	if(minX < maxX && minY < maxY)
    		area -= (maxX - minX) * (maxY - minY);
    	return area;
    }
}