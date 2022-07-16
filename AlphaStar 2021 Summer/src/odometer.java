import java.util.*;
import java.io.*;
public class odometer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		ArrayList<Long> list = new ArrayList<Long>();
		for(int i = 0; i <= 9; i++) {
			for(int j = 0; j <= 9; j++) {
				if(i == j)
					continue;
				for(int k = 3; k <= 16; k++) {
					for(int l = 0; l < k; l++) {
						if(i == 0 && l != 0)
							continue;
						if(j == 0 && l == 0)
							continue;
						String temp = "";
						for(int m = 0; m < k; m++) {
							if(l == m)
								temp += String.valueOf(j);
							else
								temp += String.valueOf(i);
						}
						list.add(Long.parseLong(temp));
					}
				}
			}
		}
		list.add((long)(Math.pow((long)(10), (long)(16))));
		Collections.sort(list);
		int start = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) >= x) {
				start = i;
				break;
			}
		}
		int end = 0;
		for(int i = list.size() - 1; i >= 0; i--) {
			if(list.get(i) <= y) {
				end = i;
				break;
			}
		}
		System.out.println(end - start + 1);
		br.close();
	}
}