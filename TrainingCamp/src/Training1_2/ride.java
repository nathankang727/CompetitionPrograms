package Training1_2;
/*
ID: nathank3
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;
public class ride {
    static Scanner in;
    static PrintWriter out;
    static String s1;
    static String s2;
    public static void main(String[] args) {
        try {
            in = new Scanner(new File("ride.in"));
            out = new PrintWriter(new File("ride.out"));
            init();
            out.println(solve());
            out.close();
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() {
    	s1 = in.nextLine();
    	s2 = in.nextLine();
    }
    private static String solve() {
        int n1 = convert(s1);
        int n2 = convert(s2);
        return n1 % 47 == n2 % 47 ? "GO" : "STAY";
    }
    private static int convert(String s) {
    	int n = 1;
    	for(int i = 0; i < s.length(); i++)
    		n *= (s.charAt(i) - 'A' + 1);
    	return n;
    }
}