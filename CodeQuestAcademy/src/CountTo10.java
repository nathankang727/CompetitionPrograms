import java.io.*;
public class CountTo10 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int bits = Integer.parseInt(br.readLine());
			for(int j = 0; j < (int)(Math.pow(2, bits)); j++)
				System.out.println(format(Integer.toString(j, 2), bits));
		}
		br.close();
	}
	public static String format(String s, int len) {
		while(s.length() < len)
			s = "0" + s;
		return s;
	}
}