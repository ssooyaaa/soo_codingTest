import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
        	String s = br.readLine();
        	
        	StringBuilder sb = new StringBuilder();
        	sb.append(s.charAt(0));
        	sb.append(s.charAt(s.length()-1));
        	
        	System.out.println(sb.toString());
        }
    }
}