package Dec2019Silver;
import java.io.*;
public class moobuzz {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("moobuzz.in")));
    	PrintWriter pw = new PrintWriter(new FileWriter(new File("moobuzz.out")));
    	int n = Integer.parseInt(br.readLine()) - 1;
    	int[] nums = {1, 2, 4, 7, 8, 11, 13, 14};
    	pw.println(nums[n % 8] + n / 8 * 15);
    	br.close();
    	pw.close();
    }
}