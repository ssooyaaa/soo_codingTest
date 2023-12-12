import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String s = br.readLine();
        int len = s.length();
        int count = len/10;
        
        int start = 0;
        while(count-->0) {
        	System.out.println(s.substring(start,start+10));
        	start += 10;
        }
        
        System.out.println(s.substring(start));
    }
}