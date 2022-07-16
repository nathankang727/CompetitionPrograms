import java.util.*;
import java.io.*;
public class namenum {
	static String input, letters[][];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		ArrayList<String> dictionary = new ArrayList<String>();
		while(sc.hasNextLine())
			dictionary.add(sc.nextLine());
		Collections.sort(dictionary);
		String allLetters = "ABCDEFGHIJKLMNOPRSTUVWXY";
    	letters = new String[8][3];
    	int count = 0;
    	for(int i = 0; i < 8; i++) {
    		for(int j = 0; j < 3; j++) {
    			letters[i][j] = allLetters.substring(count, count + 1);
    			count++;
    		}
    	}
    	boolean b = false;
    	for(int i = 0; i < dictionary.size(); i++) {
    		String word = dictionary.get(i);
    		boolean didBreak = false;
    		if(word.length() != input.length())
    			continue;
    		for(int j = 0; j < input.length(); j++) {
    			if(!contains(word.substring(j, j + 1), j)) {
    				didBreak = true;
    				break;
    			}
    		}
    		if(!didBreak) {
    			System.out.println(word);
    			b = true;
    		}
    	}
    	if(!b)
    		System.out.println("NONE");
		sc.close();
	}
	public static boolean contains(String s, int index) {
    	String possible = "";
    	for(int i = 0; i < 3; i++)
    		possible += letters[Integer.parseInt(input.substring(index, index + 1)) - 2][i];
    	return possible.contains(s);
    }
}