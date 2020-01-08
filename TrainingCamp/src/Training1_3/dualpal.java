package Training1_3;
/*
ID: nathank3
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
public class dualpal {
    static BufferedReader in;
    static PrintWriter out;
    static int n;
    static int s;
    static int[] res;
    public static void main(String[] args) {
        try {
            in = new BufferedReader(new FileReader(new File("dualpal.in")));
            out = new PrintWriter(new File("dualpal.out"));
            init();
            out.print(solve());
            out.close();
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	String[] ss = in.readLine().split(" ");
    	n = Integer.parseInt(ss[0]);
    	s = Integer.parseInt(ss[1]);
    	res = new int[n];
    }
    private static String solve() {
    	int c = 1;
    	int add = 1;
    	while(c <= n) {
    		int num = add + s;
    		int count = 0;
    		for(int i = 2; i <= 10; i++)
    			if(palindrome(Integer.toString(num, i)))
    				count++;
    		if(count > 1) {
    			res[c - 1] = num;
    			c++;
    		}
    		add++;
    	}
    	String result = "";
    	for(int i = 0; i < n; i++)
    		result += res[i] + "\n";
    	return result;
    }
    private static boolean palindrome(String str) {
    	String reverse = "";
    	for(int i = str.length() - 1; i >= 0; i--)
    		reverse += str.charAt(i) + "";
    	return reverse.equals(str);
    }
}