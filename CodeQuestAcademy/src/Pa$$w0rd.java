import java.io.*;
public class Pa$$w0rd {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			String str = br.readLine();
			if(str.length() < 8) {
				System.out.println("INVALID");
				continue;
			}
			int cnt = 0;
			if(validA(str))
				++cnt;
			if(valida(str))
				++cnt;
			if(valid0(str))
				++cnt;
			if(valid_(str))
				++cnt;
			if(cnt < 3) {
				System.out.println("INVALID");
				continue;
			}
			boolean didBreak = false;
			for(int j = 0; j < str.length() - 2; j++) {
				if(str.charAt(j) == str.charAt(j + 1) && str.charAt(j + 1) == str.charAt(j + 2)) {
					System.out.println("INVALID");
					didBreak = true;
					break;
				}
			}
			if(!didBreak)
				System.out.println("VALID");
		}
		br.close();
	}
	public static boolean validA(String s) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i < s.length(); i++)
			if(alphabet.contains(s.substring(i, i + 1)))
				return true;
		return false;
	}
	public static boolean valida(String s) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < s.length(); i++)
			if(alphabet.contains(s.substring(i, i + 1)))
				return true;
		return false;
	}
	public static boolean valid0(String s) {
		String numbers = "0123456789";
		for(int i = 0; i < s.length(); i++)
			if(numbers.contains(s.substring(i, i + 1)))
				return true;
		return false;
	}
	public static boolean valid_(String s) {
		String avoid = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for(int i = 0; i < s.length(); i++)
			if(!avoid.contains(s.substring(i, i + 1)))
				return true;
		return false;
	}
}