import java.io.*;
public class trib {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int times = Integer.parseInt(in.readLine());
		for(int i = 0; i < times; i++) {
			int iterate = Integer.parseInt(in.readLine());
			if(iterate == -1)
				System.out.println("-1");
			else if(iterate == 0)
				System.out.println("0");
			else if(iterate > 0) {
				int prevprev = -1;
				int prev = 0;
				int now = 1;
				for(int i2 = 0; i2 < iterate - 1; i2++) {
					int temp = now;
					int temp2 = prev;
					now = prevprev + prev + now;
					prev = temp;
					prevprev = temp2;
				}
				System.out.println(now);
			}
			else {
				int one = -1;
				int two = 0;
				int three = 1;
				for(int j = -2; j >= iterate; j--) {
					int temp = three - two - one;
					three = two;
					two = one;
					one = temp;
				}
				System.out.println(one);
			}
		}
	}
}