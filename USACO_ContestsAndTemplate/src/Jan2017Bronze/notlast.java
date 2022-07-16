package Jan2017Bronze;
import java.util.*;
import java.io.*;
public class notlast {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[] milk;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("notlast.in")));
            pw = new PrintWriter(new File("notlast.out"));
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
    	milk = new int[7];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		milk[nameToIndex(st.nextToken())] += Integer.parseInt(st.nextToken());
    	}
    }
    private static String solve() {
    	Set<Integer> sorting = new TreeSet<Integer>();
    	for(int i = 0; i < 7; i++)
    		sorting.add(milk[i]);
    	ArrayList<Integer> sorted = new ArrayList<Integer>();
    	for(int i : sorting)
    		sorted.add(i);
    	Collections.sort(sorted);
    	String res = "";
    	if(sorted.size() < 2)
    		res = "Tie";
    	else {
    		int secondMin = sorted.get(1);
    		int count = 0;
    		for(int i = 0; i < 7; i++) {
    			if(milk[i] == secondMin) {
    				++count;
    				res += indexToName(i);
    			}
    		}
    		if(count > 1)
    			res = "Tie";
    	}
        return res;
    }
    private static int nameToIndex(String s) {
    	if(s.equals("Bessie"))
    		return 0;
    	else if(s.equals("Elsie"))
    		return 1;
    	else if(s.equals("Daisy"))
    		return 2;
    	else if(s.equals("Gertie"))
    		return 3;
    	else if(s.equals("Annabelle"))
    		return 4;
    	else if(s.equals("Maggie"))
    		return 5;
    	else
    		return 6;
    }
    private static String indexToName(int i) {
    	if(i == 0)
    		return "Bessie";
    	else if(i == 1)
    		return "Elsie";
    	else if(i == 2)
    		return "Daisy";
    	else if(i == 3)
    		return "Gertie";
    	else if(i == 4)
    		return "Annabelle";
    	else if(i == 5)
    		return "Maggie";
    	else
    		return "Henrietta";
    }
}