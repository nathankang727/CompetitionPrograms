import java.util.*;
import java.io.*;
public class ZIPPERtext {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int u = sc.nextInt();
			int[] ul = new int[u];
			for(int j = 0; j < u; j++)
				ul[j] = sc.nextInt();
			int l = sc.nextInt();
			int[] ll = new int[l];
			for(int j = 0; j < l; j++)
				ll[j] = sc.nextInt();
			sc.nextLine();
			String encoded = "";
			while(sc.hasNextLine())
				encoded += sc.nextLine();
			String message = "";
			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			int index = 0;
			for(int j = 0; j < u; j++) {
				String temp = "";
				while(temp.length() < ul[j] && index < encoded.length()) {
					if(alphabet.contains(encoded.substring(index, index + 1)))
						temp += encoded.substring(index, index + 1);
					else if(encoded.substring(index, index + 1).equals("-"))
						temp += " ";
					++index;
				}
				message += temp + "\n";
			}
			System.out.println(message);
			message = "";
			alphabet = "abcdefghijklmnopqrstuvwxyz";
			index = 0;
			for(int j = 0; j < l; j++) {
				String temp = "";
				while(temp.length() < ll[j] && index < encoded.length()) {
					if(alphabet.contains(encoded.substring(index, index + 1)))
						temp += encoded.substring(index, index + 1);
					else if(encoded.substring(index, index + 1).equals("="))
						temp += " ";
					++index;
				}
				message += temp + "\n";
			}
			System.out.print(message);
		}
		sc.close();
	}
}