import java.io.*;
public class NotSoSelfDriving {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String[] split = br.readLine().split(":");
			double v = Double.parseDouble(split[0]);
			double x = Double.parseDouble(split[1]);
			if(v == 0)
				System.out.println("SAFE");
			else if(x / v <= 1.0)
				System.out.println("SWERVE");
			else if(x / v <= 5.0)
				System.out.println("BRAKE");
			else
				System.out.println("SAFE");
		}
		br.close();
	}
}