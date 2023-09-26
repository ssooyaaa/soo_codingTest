import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer,Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			int card = Integer.parseInt(st.nextToken());
			
			if(!map.containsKey(card)) {
				map.put(card, 1);
			}else {
				int count = map.get(card);
				map.put(card,count+1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int card = Integer.parseInt(st.nextToken());
			
			if(!map.containsKey(card)) {
				sb.append(0).append(" ");
			}else {
				sb.append(map.get(card)).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}