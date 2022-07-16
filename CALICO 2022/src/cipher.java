import java.util.*;
import java.io.*;
public class cipher {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(in.readLine());
		for(int i = 0; i < count; i++) {
			StringBuilder line = new StringBuilder();
			line.append(in.readLine());
			int ciphers = Integer.parseInt(in.readLine());
			StringTokenizer str = new StringTokenizer(in.readLine());
			char[] ds = new char[ciphers];
			int[] nums = new int[ciphers];
			for(int n = 0; n < ciphers; n++) {
				String d = str.nextToken();
				ds[n] = d.charAt(0);
				if(d.charAt(0) == 'C')
					nums[n] = Integer.parseInt(d.substring(1));
			}
			for(int n = ciphers - 1; n >= 0; n--) {
				if(ds[n] == 'A') {
					for(int i2 = 0; i2 < line.length(); i2 ++) {
						if(al(line.charAt(i2))) {
							String temp = line.substring(0, i2) + (char)(122-(line.charAt(i2) - 97)) + line.substring(i2 + 1);
							line.setLength(0);
							line.append(temp);
						}
					}
				}
				else if(ds[n] == 'C') {
					int f = nums[n];
					for(int i2 = 0; i2 < line.length(); i2 ++) {
						if(al(line.charAt(i2))) {
							String temp = line.substring(0, i2) + ca(line.charAt(i2), f) + line.substring(i2 + 1);
							line.setLength(0);
							line.append(temp);
						}
					}
				}
				else {
					line = line.reverse();
				}
			}
			System.out.println(line);
			if(i < count - 1)
				in.readLine();
		}
	}
	public static boolean al(char a) {
		return a >= 97 && a <= 122;
	}
	public static char ca(char a, int b) {
		int c = a - 97;
		c -= b;
		c %= 26;
		if(c < 0) {
			c = 26 + c;
		}
		return (char)(c + 97);
	}
}