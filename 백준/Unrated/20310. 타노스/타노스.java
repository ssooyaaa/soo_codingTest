import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		
		Map<Character,Integer> map = new HashMap<>();
		
		for(int i=0;i<N.length();i++) {
			char c = N.charAt(i);
			if(c=='0') {
				map.put(c,map.getOrDefault(c, 0)+1);
			}else {
				map.put(c, map.getOrDefault(c, 0)+1);
			}
		}
		
		map.put('0', map.get('0')/2);
		map.put('1', map.get('1')/2);
		
		for(int i=0;i<map.get('0');i++) {
			System.out.print("0");
		}
		
		for(int i=0;i<map.get('1');i++) {
			System.out.print("1");
		}
    }
	
	  
    
}

