import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			
			answer = Math.max(answer, now-min);
			min = Math.min(min, now);
		}
		System.out.println(answer);
	}
		
}