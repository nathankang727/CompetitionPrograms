import java.util.*;
public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int[] arr = new int[3];
			String[] input = sc.nextLine().split(" ");
			for(int j = 0; j < input.length; j++) {
				if(input[j].equals("R"))
					++arr[0];
				else if(input[j].equals("P"))
					++arr[1];
				else
					++arr[2];
			}
			if(arr[0] == 1 && arr[1] == 0)
				System.out.println("ROCK");
			else if(arr[1] == 1 && arr[2] == 0)
				System.out.println("PAPER");
			else if(arr[2] == 1 && arr[0] == 0)
				System.out.println("SCISSORS");
			else
				System.out.println("NO WINNER");
		}
		sc.close();
	}
}
