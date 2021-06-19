package Jan2017Silver;
import java.util.*;
import java.io.*;
public class cowcode {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("cowcode.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("cowcode.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		long n = Long.parseLong(st.nextToken()) - 1;
		int length = s.length();
		ArrayList<Long> a = new ArrayList<Long>();
		a.add((long)(length));
		while(a.get(a.size() - 1) <= n)
			a.add(a.get(a.size() - 1) * 2);
		Collections.sort(a, Collections.reverseOrder());
		while(n >= length) {
			if(n == a.get(0))
				--n;
			else if(n > a.get(0))
				n = n - a.get(0) - 1;
			a.remove(0);
		}
		pw.println(s.charAt((int)(n)));
		br.close();
		pw.close();
	}
}