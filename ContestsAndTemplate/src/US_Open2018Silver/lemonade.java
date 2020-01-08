package US_Open2018Silver;
import java.util.*;
import java.io.*;
public class lemonade {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] w;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("lemonade.in")));
            pw = new PrintWriter(new File("lemonade.out"));
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
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	w = new int[n];
    	int[] w1 = new int[n];
    	for(int i = 0; i < n; i++)
    		w1[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(w1);
    	for(int i = n - 1, j = 0; i > -1; i--) {
    		w[j] = w1[i];
    		++j;
    	}
    }
    private static String solve() {
    	int count = 0;
    	for(int i = 0; i < n; i++)
    		if(count <= w[i])
    			++count;
        return String.valueOf(count);
    }
}