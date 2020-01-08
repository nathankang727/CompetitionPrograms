package Training1_3;
/*
ID: nathank3
LANG: JAVA
TASK: palsquare
*/
import java.util.*;
import java.io.*;
public class palsquare {
    static BufferedReader in;
    static PrintWriter out;
    static int b;
    static ArrayList<String> answers1;
    static ArrayList<String> answers2;
    public static void main(String[] args) {
        try {
            in = new BufferedReader(new FileReader(new File("palsquare.in")));
            out = new PrintWriter(new File("palsquare.out"));
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
    	b = Integer.parseInt(in.readLine());
    	answers1 = new ArrayList<String>();
    	answers2 = new ArrayList<String>();
    }
    private static String solve() {
        for(int i = 1; i < 301; i++) {
        	if(palindrome(Integer.toString(i * i, b))) {
        		answers1.add(Integer.toString(i, b));
        		answers2.add(Integer.toString(i * i, b));
        	}
        }
        String res = "";
        for(int i = 0; i < answers1.size(); i++)
        	res += answers1.get(i).toUpperCase() + " " + answers2.get(i).toUpperCase() + "\n";
        return res;
    }
    private static boolean palindrome(String s) {
    	String reverse = "";
    	for(int i = s.length() - 1; i >= 0; i--)
    		reverse += s.charAt(i) + "";
    	return reverse.equals(s);
    }
}