package US_Open2017Bronze;
import java.util.*;
import java.io.*;
public class lostcow {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("lostcow.in")));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("lostcow.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int pos = x;
		int prev = x;
		int count = 0;
		int distance = 0;
		boolean east = x < y;
		while(east && pos < y || !east && pos > y) {
			if(count % 2 == 0)
				pos = x + (int)(Math.pow(2, count));
			else
				pos = x - (int)(Math.pow(2, count));
			++count;
			distance += Math.abs(prev - pos);
			prev = pos;
		}
		distance += Math.abs(prev - pos);
		distance -= Math.abs(y - pos);
		pw.println(distance);
		br.close();
		pw.close();
	}
}