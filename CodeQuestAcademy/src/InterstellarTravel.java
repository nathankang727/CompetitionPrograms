import java.util.*;
import java.io.*;
public class InterstellarTravel {
	static HashMap<Character, Integer> starEnergy;
	static int dX[] = {1, -1, 0, 0, 0, 0};
	static int dY[] = {0, 0, 1, -1, 0, 0};
	static int dZ[] = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		HashMap<Character, Integer> starEnergy = new HashMap<Character, Integer>();
		starEnergy.put('M', 3);
		starEnergy.put('K', 4);
		starEnergy.put('G', 5);
		starEnergy.put('F', 6);
		starEnergy.put('A', 7);
		starEnergy.put('B', 8);
		starEnergy.put('O', 9);
		for(int a = 0; a < t; a++) {
			int l = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < n; i++) {
				
			}
		}
		br.close();
	}
}