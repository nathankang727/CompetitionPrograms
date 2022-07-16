import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
public class CalculatOR {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.HALF_UP);
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			char op = st.nextToken().charAt(0);
			double b = Double.parseDouble(st.nextToken());
			if(op == '+')
				System.out.println(df.format(a + b) + " " + df.format(b + a));
			if(op == '-')
				System.out.println(df.format(a - b) + " " + df.format(b - a));
			if(op == '*')
				System.out.println(df.format(a * b) + " " + df.format(b * a));
			if(op == '/')
				System.out.println(df.format(a / b) + " " + df.format(b / a));
		}
		br.close();
	}
}