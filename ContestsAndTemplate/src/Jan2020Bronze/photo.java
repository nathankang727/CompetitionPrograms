package Jan2020Bronze;
import java.util.*;
import java.io.*;
public class photo {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] b;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("photo.in")));
            pw = new PrintWriter(new File("photo.out"));
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
    	b = new int[n];
    	for(int i = 1; i < b.length; i++)
    		b[i] = Integer.parseInt(st.nextToken());
    }
    private static String solve() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i = 1; i < b[1]; i++) {
    		if(i > n || b[1] - i > n || i == b[1] - i)
    			continue;
    		else
    			list.add(i);
    	}
    	String res = "";
    	for(int i = 0; i < list.size(); i++) {
    		String s = "";
        	boolean didBreak = false;
    		int n1 = list.get(i);
    		int n2 = b[1] - list.get(i);
    		s = n1 + " " + n2 + " ";
    		for(int j = 2; j < n; j++) {
    			n1 = n2;
    			n2 = b[j] - n1;
    			s += n2 + " ";
    			if(n1 > n || n2 > n || n1 == n2) {
    				didBreak = true;
    				break;
    			}
    		}
    		if(!didBreak)
    			res = s;
    	}
        return res;
    }
}