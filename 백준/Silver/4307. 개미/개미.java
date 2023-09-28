import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int l = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int fast = 0;
			int slow = 0;
			
			int[] ant = new int[n];
			
			for(int i=0;i<n;i++) {
				ant[i]=Integer.parseInt(br.readLine());
			}
			
			for(int i=0;i<ant.length;i++) {
				int first = Math.abs(ant[i]-0);
				int end = Math.abs(ant[i]-l);
				
				int moreFast = Math.min(first, end);
				
				fast = Math.max(moreFast, fast);
			}
			
			for(int i=0;i<ant.length;i++) {
				int first = Math.abs(ant[i]-0);
				int end = Math.abs(ant[i]-l);
				
				int moreSlow = Math.max(first, end);
				
				slow = Math.max(moreSlow, slow);
			}
			
			System.out.println(fast+" "+slow);
		}
	}

}