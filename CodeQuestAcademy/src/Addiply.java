import java.util.*;
import java.io.*;
public class Addiply {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println((a + b) + " " + (a * b));
		}
		sc.close();
	}
}