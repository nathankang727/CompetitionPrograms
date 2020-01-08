package Dec2019Silver;
import java.io.*;
public class moobuzz {
    static BufferedReader br;
    static PrintWriter pw;
    static int n;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("moobuzz.in")));
            pw = new PrintWriter(new File("moobuzz.out"));
            pw.println(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static String solve() throws IOException {
    	n = Integer.parseInt(br.readLine());
    	int firstPart = 1 + 15 * (n / 8);
    	if(n % 8 == 0)
    		firstPart -= 15;
    	int[] adding = {0, 1, 3, 6, 7, 10, 12, 13};
        return String.valueOf(firstPart + (adding[(8 + (n % 8 - 1)) % 8]));
    }
}