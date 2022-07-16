import java.io.*;
public class typo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int totalFront = 0;
		int totalBack = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(')
				++totalFront;
			else
				++totalBack;
		}
		if(totalFront == totalBack)
			System.out.println("0");
		else {
			int front = 0;
			int back = 0;
			int closedCount = 0;
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == '(') {
					++front;
					++closedCount;
				}
				else {
					++back;
					--closedCount;
				}
				if(closedCount < 2)
					front = 0;
				if(closedCount < 0)
					break;
			}
			System.out.println(closedCount > 0 ? front : back);
		}
		br.close();
	}
}