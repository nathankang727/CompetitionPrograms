/*
ID: nathank3
LANG: JAVA
TASK:
*/
import java.io.*;
public class template {
    static BufferedReader br;
    static PrintWriter pw;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("xxx.in")));
            pw = new PrintWriter(new File("xxx.out"));
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
    	
    }
    private static String solve() {
        return "";
    }
}