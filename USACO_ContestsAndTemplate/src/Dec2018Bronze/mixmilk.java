package Dec2018Bronze;
import java.util.*;
import java.io.*;
public class mixmilk {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("mixmilk.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("mixmilk.out")));
		long[][] milk = new long[3][2];
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			milk[i][0] = Long.parseLong(st.nextToken());
			milk[i][1] = Long.parseLong(st.nextToken());
		}
		for(int i = 0; i < 100; i++) {
			long add = 0;
			if(i % 3 == 0) {
				add = milk[0][1] + milk[1][1];
				if(add > milk[1][0]) {
					milk[1][1] = milk[1][0];
					milk[0][1] = add - milk[1][0];
				}
				else {
					milk[1][1] = add;
					milk[0][1] = 0;
				}
			}
			else if(i % 3 == 1) {
				add = milk[1][1] + milk[2][1];
				if(add > milk[2][0]) {
					milk[2][1] = milk[2][0];
					milk[1][1] = add - milk[2][0];
				}
				else {
					milk[2][1] = add;
					milk[1][1] = 0;
				}
			}
			else {
				add = milk[2][1] + milk[0][1];
				if(add > milk[0][0]) {
					milk[0][1] = milk[0][0];
					milk[2][1] = add - milk[0][0];
				}
				else {
					milk[0][1] = add;
					milk[2][1] = 0;
				}
			}
		}
		for(int i = 0; i < 3; i++)
			pw.println(milk[i][1]);
		br.close();
		pw.close();
	}
}