package Dec2017Silver;
import java.util.*;
import java.io.*;
public class measurement {
    static BufferedReader br;
    static PrintWriter pw;
    static int n, g;
    static Map<Integer, meme> day;
    static Map<Integer, Integer> cow;
    static TreeMap<Integer, Integer> milk;
    static Collection<meme> val;
    public static void main(String[] args) {
        try {
        	br = new BufferedReader(new FileReader(new File("measurementSilver.in")));
            pw = new PrintWriter(new File("measurementSilver.out"));
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
    	g = Integer.parseInt(st.nextToken());
    	day = new TreeMap<Integer, meme>();
    	milk = new TreeMap<Integer, Integer>();
    	cow = new HashMap<Integer, Integer>();
    	for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int nums = Integer.parseInt(st.nextToken());
    		day.put(nums, new meme(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    	}
    	milk.put(g, 100000);
    	val = day.values();
    	for(meme v : val)
    		cow.put(v.id, g);
    }
    private static String solve() {
    	int countingChange = 0;
    	int max = g;
    	int wasBoard = g;
    	int board = 100000;
    	for(meme v : val) {
    		board = milk.lastEntry().getValue();
    		if(!cow.containsKey(v.id))
    			cow.put(v.id, g);
    		int m = cow.get(v.id);
    		if(milk.get(m) == 1)
    			milk.remove(m);
    		else
    			milk.put(m,  milk.get(m) - 1);
    		if(max == m)
    			wasBoard = max + v.milk;
    		m += v.milk;
    		cow.put(v.id, m);
    		int t = 0;
    		if(milk.containsKey(m))
    			t = milk.get(m);
    		milk.put(m, t + 1);
    		max = milk.lastKey();
    		if(max != wasBoard || milk.lastEntry().getValue() != board) {
    			++countingChange;
    			wasBoard = max;
    		}
    	}
    	return String.valueOf(countingChange);
    }
}
class meme {
	int id;
	int milk;
    meme(int l, int r) {
    	id = l;
    	milk = r;
    }
    public String toString() {
    	return id + " " + milk;
    }
}