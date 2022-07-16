package Jan2017Bronze;
import java.util.*;
import java.io.*;
public class hps {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static String[] possibleCases = {"122331", "133221", "211332", "233112", "311223", "322113"};
    static int[][] games;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("hps.in")));
            pw = new PrintWriter(new File("hps.out"));
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
    	games = new int[n][2];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		games[i][0] = Integer.parseInt(st.nextToken());
    		games[i][1] = Integer.parseInt(st.nextToken());
    	}
    }
    private static String solve() {
    	int maxWins = 0;
    	for(int i = 0; i < 6; i++) {
    		int wins = 0;
    		String winCase = possibleCases[i];
    		for(int j = 0; j < n; j++) {
    			String game = games[j][0] + "" + games[j][1];
    			if(winCase.indexOf(game) > -1 && games[j][0] != games[j][1])
    				++wins;
    		}
    		if(wins > maxWins)
    			maxWins = wins;
    	}
    	return String.valueOf(maxWins);
    }
}