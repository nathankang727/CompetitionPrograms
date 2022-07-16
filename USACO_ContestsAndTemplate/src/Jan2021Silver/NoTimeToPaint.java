package Jan2021Silver;
import java.util.*;
import java.io.*;
public class NoTimeToPaint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] p = new int[n];
		int[] s = new int[n];
		char[] a = new char[n];
		a = br.readLine().toCharArray();
		p[0] = 1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put(a[0], 0);
		for(int i = 1; i < n; i++) {
			p[i] = p[i - 1];
			if(!map.containsKey(a[i]))
				p[i]= p[i - 1] + 1;
			else if(a[i] > a[i - 1])
				p[i] = p[i - 1] + 1;
			else if(a[i] < a[i - 1]) {
				for(char key : map.keySet()) {
					if(key >= a[i])
						continue;
					if(map.get(key) > map.get(a[i])) {
						p[i] = p[i - 1] + 1;
						break;
					}
				}
			}
			map.put(a[i], i);
		}
		map = new HashMap<Character, Integer>();
		s[n - 1] = 1;
		map.put(a[n - 1], n - 1);
		for(int i = n - 2; i >= 0; i--) {
			s[i] = s[i + 1];
			if(!map.containsKey(a[i]))
				s[i]= s[i + 1] + 1;
			else if(a[i] > a[i+1])
				s[i] = s[i+1]+1;
			else if (a[i] < a[i + 1]) {
				for(char key : map.keySet()) {
					if(key >= a[i])
						continue;
					if(map.get(key) < map.get(a[i])) {
						s[i] = s[i + 1] + 1;
						break;
					}
				}
			}
			map.put(a[i], i);
		}
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int ans = 0;
			if(x == 0 && y == n - 1)
				ans = 0;
			else if(x == 0)
				ans = s[y + 1];
			else if (y == n - 1)
				ans = p[x - 1];
			else
				ans = s[y + 1] + p[x - 1];			
			System.out.println(ans);
		}
		br.close();
	}
}