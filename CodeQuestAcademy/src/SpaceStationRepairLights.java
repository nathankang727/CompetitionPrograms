import java.util.*;
public class SpaceStationRepairLights {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int error = 0;
			for(int j = 3; j >= 0; j--)
				if(st.nextToken().equals("BROKEN"))
					error += (int)(Math.pow(2, j));
			convert(error);
		}
		sc.close();
	}
	public static void convert(int n) {
		if(n == 0)
			System.out.println("off off");
		else if(n == 1)
			System.out.println("off red");
		else if(n == 2)
			System.out.println("off green");
		else if(n == 3)
			System.out.println("off blue");
		else if(n == 4)
			System.out.println("red off");
		else if(n == 5)
			System.out.println("red red");
		else if(n == 6)
			System.out.println("red green");
		else if(n == 7)
			System.out.println("red blue");
		else if(n == 8)
			System.out.println("green off");
		else if(n == 9)
			System.out.println("green red");
		else if(n == 10)
			System.out.println("green green");
		else if(n == 11)
			System.out.println("green blue");
		else if(n == 12)
			System.out.println("blue off");
		else if(n == 13)
			System.out.println("blue red");
		else if(n == 14)
			System.out.println("blue green");
		else
			System.out.println("blue blue");
	}
}