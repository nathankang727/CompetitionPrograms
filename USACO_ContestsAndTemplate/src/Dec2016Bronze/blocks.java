package Dec2016Bronze;
import java.util.*;
import java.io.*;
public class blocks {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static String[][] words;
    static int[] letters;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("blocks.in")));
            pw = new PrintWriter(new File("blocks.out"));
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
    	n = Integer.parseInt(br.readLine());
    	words = new String[n][2];
    	for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
    		words[i][0] = st.nextToken();
    		words[i][1] = st.nextToken();
    	}
    	letters = new int[26];
    }
    private static String solve() {
    	for(int i = 0; i < n; i++) {
    		int[] letters0 = new int[26];
    		int[] letters1 = new int[26];
    		for(int j = 0; j < words[i][0].length(); j++)
    			++letters0[words[i][0].charAt(j) - 'a'];
    		for(int j = 0; j < words[i][1].length(); j++)
    			++letters1[words[i][1].charAt(j) - 'a'];
    		for(int j = 0; j < 26; j++)
    			letters[j] += Math.max(letters0[j], letters1[j]);
    	}
        String result = "";
        for(int i = 0; i < 26; i++)
        	result += letters[i] + "\n";
        return result;
    }
}