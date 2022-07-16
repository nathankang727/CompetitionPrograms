import java.util.*;
public class WhosTheValedictorian {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			String school = sc.nextLine();
			int n = Integer.parseInt(sc.nextLine());
			String student = "";
			double gpa = 0.0;
			int creditHours = 0;
			for(int j = 0; j < n; j++) {
				String input = sc.nextLine();
				String name = input.substring(0, input.indexOf(":"));
				input = input.substring(input.indexOf(":") + 1);
				String[] grades = input.split(",");
				int value = 0;
				int temp = 0;
				for(int k = 0; k < grades.length; k++) {
					temp += Integer.parseInt(grades[k].substring(1));
					value += (4 - (grades[k].charAt(0) - 'A')) * Integer.parseInt(grades[k].substring(1));
				}
				double tempGPA = (double)(value) / (double)(temp);
				if(tempGPA > gpa || tempGPA == gpa && temp > creditHours) {
					student = name;
					gpa = tempGPA;
					creditHours = temp;
				}
			}
			System.out.println(school + " = " + student);
		}
		sc.close();
	}
}