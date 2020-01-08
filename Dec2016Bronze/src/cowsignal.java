import java.util.*;
import java.io.*;
public class cowsignal {
    static BufferedReader br;
    static PrintWriter pw;
    static int m;
    static int n;
    static int k;
    static String[] poster;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("cowsignal.in")));
            pw = new PrintWriter(new File("cowsignal.out"));
            init();
            pw.print(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	poster = new String[m];
    	for(int i = 0; i < m; i++)
    		poster[i] = br.readLine();
    }
    private static String solve() {
    	String s = "";
        for(int i = 0; i < m; i++) {
        	for(int i2 = 0; i2 < k; i2++) {
        		for(int j = 0; j < n; j++) {
        			String sub = poster[i].substring(j, j + 1);
        			for(int l = 0; l < k; l++)
        				s += sub;
        		}
        		s += "\n";
        	}
        }
        return s;
    }
}