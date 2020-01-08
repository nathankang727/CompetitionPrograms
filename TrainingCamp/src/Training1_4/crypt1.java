package Training1_4;
/*
ID: nathank3
LANG: JAVA
TASK: crypt1
*/
import java.util.*;
import java.io.*;
public class crypt1 {
    static BufferedReader in;
    static PrintWriter out;
    static int[] digits;
    static int[] row1;
    static int[] row2;
    public static void main(String[] args) {
        try {
            in = new BufferedReader(new FileReader(new File("crypt1.in")));
            out = new PrintWriter(new File("crypt1.out"));
            init();
            out.println(solve());
            out.close();
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	digits = new int[Integer.parseInt(in.readLine())];
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	for(int i = 0; i < digits.length; i++)
    		digits[i] = Integer.parseInt(st.nextToken());
    	row1 = new int[(int)(Math.pow(digits.length, 3))];
    	row2 = new int[(int)(Math.pow(digits.length, 2))];
    	int index = 0;
    	for(int i = 0; i < digits.length; i++)
    		for(int j = 0; j < digits.length; j++)
    			for(int k = 0; k < digits.length; k++)
    				row1[index++] = (digits[i] * 100) + (digits[j] * 10) + digits[k];
    	index = 0;
    	for(int i = 0; i < digits.length; i++)
    		for(int j = 0; j < digits.length; j++)
				row2[index++] = (digits[i] * 10) + digits[j];
    }
    private static String solve() {
    	int count = 0;
    	for(int i = 0; i < row1.length; i++)
    		for(int j = 0; j < row2.length; j++)
    			if(works(false, row1[i], Integer.parseInt(String.valueOf(row2[j]).substring(1))))
    				if(works(false, row1[i], Integer.parseInt(String.valueOf(row2[j]).substring(0, 1))))
    					if(works(true, row1[i], row2[j]))
    						count++;
    	return String.valueOf(count);
    }
    private static boolean works(boolean b, int n, int n2) {
    	int p = n * n2;
    	if(b && String.valueOf(p).length() != 4)
    		return false;
    	else if(!b && String.valueOf(p).length() != 3)
    		return false;
    	if(contains(String.valueOf(p)))
    		return true;
    	return false;
    }
    private static boolean contains(String p) {
    	String[] dup = new String[digits.length];
    	for(int i = 0; i < dup.length; i++)
    		dup[i] = String.valueOf(digits[i]);
    	List<String> list = Arrays.asList(dup);
    	for(int i = 0; i < p.length(); i++)
    		if(!list.contains(p.substring(i, i + 1)))
    			return false;
    	return true;
    }
}