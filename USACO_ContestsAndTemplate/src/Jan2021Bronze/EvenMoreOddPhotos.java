package Jan2021Bronze;
import java.util.*;
import java.io.*;
public class EvenMoreOddPhotos {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int evens = 0;
		int odds = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num % 2 == 0)
				++evens;
			else
				++odds;
		}
		if(evens == odds)
			System.out.println(odds * 2);
		else if(evens > odds)
			System.out.println(odds * 2 + 1);
		else {
			int diff = (int)(Math.ceil((double)(odds - evens) / 3.0));
			odds -= 2 * diff;
			evens += diff;
			System.out.println(odds == evens ? odds * 2 : odds * 2 + 1);
		}
	}
}