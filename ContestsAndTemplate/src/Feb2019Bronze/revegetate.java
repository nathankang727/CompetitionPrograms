package Feb2019Bronze;
import java.util.*;
import java.io.*;
public class revegetate {
    static BufferedReader br;
    static PrintWriter pw;
    static int n, m;
    static int[] a, b, res;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("revegetate.in")));
            pw = new PrintWriter(new File("revegetate.out"));
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
    	a = new int[m];
    	b = new int[m];
    	res = new int[n];
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a1 = Integer.parseInt(st.nextToken());
    		int b1 = Integer.parseInt(st.nextToken());
    		if(a1 < b1) {
    			a[i] = a1;
    			b[i] = b1;
    		}
    		else {
    			a[i] = b1;
    			b[i] = a1;
    		}
    	}
    }
    private static String solve() {
    	for(int i = 0; i < n; i++) {
    		for(int j = 1; j < 5; j++) {
    			boolean isTrue = true;
    			for(int k = 0; k < m; k++)
    				if(b[k] == i + 1 && res[a[k] - 1] == j)
    					isTrue = false;
    			if(isTrue) {
    				res[i] = j;
    				break;
    			}
    		}
    	}
    	String s = "";
    	for(int i = 0; i < n; i++)
    		s += res[i];
    	return s;
    }
}