import java.io.*;
public class cow {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] word = br.readLine().toCharArray();
		long c = 0;
		long o = 0;
		long w = 0;
		for(int i = 0; i < n; i++) {
			if(word[i] == 'C')
				++c;
			else if(word[i] == 'O')
				o += c;
			else
				w += o;
		}
		System.out.println(w);
		br.close();
	}
}