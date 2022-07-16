import java.util.*;
import java.io.*;
public class Check {
    
    static void check(String ans) throws IOException {
        Scanner a = new Scanner(new File("out.txt"));
        Scanner b = new Scanner(new File(ans));
        int line = 0;
        int wrong = 0;
        while(a.hasNextLine()) {
            String s1 = a.nextLine();
            String s2 = b.nextLine();
            ++line;
//          System.out.println(s1);
//          System.out.println(s2);
//          System.out.println(s1.equals(s2));
            if(!s1.equals(s2)) {
                System.out.println(line +" error");
                wrong++;
            }    
        }
        
        if(line==0) System.out.println("no output");
        if(wrong==0) System.out.println("OK");
        
        a.close();
        b.close();        
    }    
}