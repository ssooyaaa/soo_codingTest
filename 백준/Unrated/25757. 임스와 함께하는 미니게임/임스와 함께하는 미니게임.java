import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		String type = st.nextToken();
		
		Map<String, Integer> player = new HashMap<>();
		Map<String, Integer> game = new HashMap<>();
		
		game.put("Y", 2);
		game.put("F", 3);
		game.put("O", 4);
		
		for(int i=0;i<n;i++) {
			String name = br.readLine();
			player.put(name, 1);
		}
		
		int total = player.size();
		int count = total / (game.get(type)-1);
		
		System.out.println(count);
    }
    
    
}