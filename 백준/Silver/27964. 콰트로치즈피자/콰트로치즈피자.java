import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			String s = st.nextToken();
			
			if(s.length()>=6 && s.substring(s.length()-6).equals("Cheese")) {
				map.put(s, map.getOrDefault(s, 0)+1);
			}
		}
		
		if(map.size()>=4) {
			System.out.println("yummy");
		}else
			System.out.println("sad");
		
		
    }
	
	
}
