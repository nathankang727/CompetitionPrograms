package Jan2016Bronze;
import java.util.*;
import java.io.*;
public class promote {
    static BufferedReader br;
    static PrintWriter pw;
    static int bB, aB, bS, aS, bG, aG, bP, aP;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("promote.in")));
            pw = new PrintWriter(new File("promote.out"));
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
    	bB = Integer.parseInt(st.nextToken());
    	aB = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	bS = Integer.parseInt(st.nextToken());
    	aS = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	bG = Integer.parseInt(st.nextToken());
    	aG = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	bP = Integer.parseInt(st.nextToken());
    	aP = Integer.parseInt(st.nextToken());
    }
    private static String solve() {
    	String res = "";
    	int promoteToP = aP - bP;
    	int promoteToG = promoteToP + aG - bG;
    	int promoteToS = promoteToG + aS - bS;
    	res = promoteToS + "\n" + promoteToG + "\n" + promoteToP;
        return res;
    }
}