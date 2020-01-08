package Dec2019Bronze;
import java.util.*;
import java.io.*;
public class lineup {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static int[][] constraints;
    static ArrayList<String> arrList;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("lineup.in")));
            pw = new PrintWriter(new File("lineup.out"));
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
    	constraints = new int[n][2];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		constraints[i][0] = nameToIndex(st.nextToken());
    		for(int j = 0; j < 4; j++)
    			st.nextToken();
    		constraints[i][1] = nameToIndex(st.nextToken());
    		Arrays.sort(constraints[i]);
    	}
    	arrList = new ArrayList<String>();
    }
    private static String solve() {
    	ArrayList<String> results = new ArrayList<String>();
    	permute("01234567", "");
    	Collections.sort(arrList);
    	for(int i = 0; i < arrList.size(); i++) {
    		String s1 = arrList.get(i);
    		boolean isBreak = false;
    		for(int j = 0; j < n; j++) {
    			String ss = Arrays.toString(constraints[j]);
    			String sss = ss.substring(1, 2) + ss.substring(4, 5);
    			String ssss = ss.substring(4, 5) + ss.substring(1, 2);
    			if(s1.indexOf(sss) == -1 && s1.indexOf(ssss) == -1) {
    				isBreak = true;
    				break;
    			}
    		}
    		if(!isBreak)
    			results.add(s1);
    	}
    	ArrayList<String> results2 = new ArrayList<String>();
    	for(int i = 0; i < results.size(); i++) {
    		String r = "";
    		for(int j = 0; j < 8; j++)
    			r += indexToName(Integer.parseInt(results.get(i).substring(j, j +  1))) + "\n";
    		results2.add(r);
    	}
    	Collections.sort(results2);
        return results2.get(0);
    }
    private static int nameToIndex(String name) {
    	if(name.equals("Beatrice"))
    		return 0;
    	else if(name.equals("Belinda"))
    		return 1;
    	else if(name.equals("Bella"))
    		return 2;
    	else if(name.equals("Bessie"))
    		return 3;
    	else if(name.equals("Betsy"))
    		return 4;
    	else if(name.equals("Blue"))
    		return 5;
    	else if(name.equals("Buttercup"))
    		return 6;
    	else
    		return 7;
    }
    private static String indexToName(int number) {
    	if(number == 0)
    		return "Beatrice";
    	else if(number == 1)
    		return "Belinda";
    	else if(number == 2)
    		return "Bella";
    	else if(number == 3)
    		return "Bessie";
    	else if(number == 4)
    		return "Betsy";
    	else if(number == 5)
    		return "Blue";
    	else if(number == 6)
    		return "Buttercup";
    	else
    		return "Sue";
    }
    private static void permute(String string, String result) {
    	if(string.length() == 0) {
    		arrList.add(result);
    		return;
    	}
    	for(int i = 0; i < string.length(); i++) {
    		char c = string.charAt(i);
    		String s = string.substring(0, i) + string.substring(i + 1);
    		permute(s, result + c);
    	}
    }
}