import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String s = br.readLine();
        
        List<Character> list = new ArrayList<>();
        
        for(int i=0;i<s.length();i++) {
        	list.add(s.charAt(i));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++) {
        	sb.append(list.get(i));
        }
        
        System.out.println(sb.toString());
    }
}