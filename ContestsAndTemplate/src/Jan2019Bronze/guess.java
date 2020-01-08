package Jan2019Bronze;
/*
ID: nathank3
LANG: JAVA
TASK: guess
*/
import java.util.*;
import java.io.*;
public class guess {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
	@SuppressWarnings("rawtypes")
	static ArrayList[] animals;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("guess.in")));
            pw = new PrintWriter(new File("guess.out"));
            init();
            pw.println(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
	private static void init() throws IOException {
    	n = Integer.parseInt(br.readLine());
    	animals = new ArrayList[n];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		animals[i] = new ArrayList<String>();
    		animals[i].add(st.nextToken());
    		int k = Integer.parseInt(st.nextToken());
    		for(int j = 0; j < k; j++)
    			animals[i].add(st.nextToken());
    	}
    }
    private static String solve() {
        int max = 0;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(i == j)
        			continue;
        		max = Math.max(max, sameTraits(i, j));
        	}
        }
    	return String.valueOf(max);
    }
    private static int sameTraits(int first, int second) {
    	int count = 1;
    	for(int i = 0; i < animals[first].size(); i++)
    		for(int j = 0; j < animals[second].size(); j++)
    			if(animals[first].get(i).equals(animals[second].get(j)))
    				++count;
    	return count;
    }
}