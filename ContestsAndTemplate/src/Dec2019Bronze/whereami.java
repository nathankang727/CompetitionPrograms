package Dec2019Bronze;
import java.io.*;
public class whereami {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    static String mailboxes;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("whereami.in")));
            pw = new PrintWriter(new File("whereami.out"));
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
    	mailboxes = br.readLine();
    }
    private static String solve() {
    	String str = "";
    	int num = 0;
    	for(int i = 1; i <= n; i++) {
    		boolean didBreak = false;
    		for(int j = 0; j <= n - i; j++) {
    			str = mailboxes.substring(j, j + i);
    			if(mailboxes.indexOf(str) != mailboxes.lastIndexOf(str)) {
    				didBreak = true;
    				break;
    			}
    		}
    		if(!didBreak) {
    			num = i;
    			break;
    		}
    	}
        return String.valueOf(num);
    }
}