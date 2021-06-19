import java.io.*;
public class Watermelon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(n % 2 == 0 && n > 2 ? "YES" : "NO");
		br.close();
	}
}