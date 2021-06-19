import java.util.*;
import java.io.*;
public class FarmerJohnsProblems {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int numOfProblems = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean command = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			String author = st.nextToken();
			if(command) {
				++numOfProblems;
				if(map.containsKey(author))
					map.put(author, map.get(author) + 1);
				else
					map.put(author, 1);
			}
			else {
				if(!map.containsKey(author)) {
					System.out.println("0/1");
					continue;
				}
				int gcf = greatestCommonFactor(map.get(author), numOfProblems);
				System.out.println(map.get(author) / gcf + "/" + numOfProblems / gcf);
			}
		}
		br.close();
	}
	public static int greatestCommonFactor(int n, int d) {
		int gcf = Math.min(n, d);
		for(int i = gcf; i > 0; i--) {
			if(n % gcf == 0 && d % gcf == 0)
				break;
			--gcf;
		}
		return gcf;
	}
}