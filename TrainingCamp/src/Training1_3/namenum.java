package Training1_3;
/*
ID: nathank3
LANG: JAVA
TASK: namenum
*/
import java.util.*;
import java.io.*;
public class namenum {
    static BufferedReader in;
    static BufferedReader br;
    static PrintWriter out;
    static String[] names;
    static String n;
    static ArrayList<String> s;
    static String[][] letters;
    public static void main(String[] args) {
        try {
            in = new BufferedReader(new FileReader(new File(("namenum.in"))));
            out = new PrintWriter(new File("namenum.out"));
            br = new BufferedReader(new FileReader(new File("dict.txt")));
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
    	names = new String[4617];
    	for(int i = 0; i < 4617; i++)
    		names[i] = br.readLine();
    	n = in.readLine();
    	s = new ArrayList<String>();
    	String allLetters = "ABCDEFGHIJKLMNOPRSTUVWXY";
    	letters = new String[8][3];
    	int count = 0;
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 3; j++) {
    			letters[i][j] = allLetters.substring(count, count + 1);
    			count++;
    		}
    	}
    }
    private static String solve() {
    	for(int i = 0; i < 4617; i++) {
    		String word = names[i];
    		boolean didBreak = false;
    		if(word.length() != n.length())
    			continue;
    		for(int j = 0; j < n.length(); j++) {
    			if(!contains(word.substring(j, j + 1), j)) {
    				didBreak = true;
    				break;
    			}
    		}
    		if(!didBreak)
    			s.add(word);
    	}
    	String res = "";
    	for(String s1: s)
        	res += s1 + "\n";
    	if(res == "")
    		return "NONE\n";
    	return res;
    }
    private static boolean contains(String s, int index) {
    	String possible = "";
    	for(int i = 0; i < 3; i++)
    		possible += letters[Integer.parseInt(n.substring(index, index + 1)) - 2][i];
    	return possible.contains(s);
    }
}