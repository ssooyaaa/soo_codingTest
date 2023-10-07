import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[10001];
		prime[0]=prime[1]=true;
		for(int i=2;i<=Math.sqrt(prime.length);i++) {
			if(prime[i]) continue;
			
			for(int j=i*i;j<prime.length;j+=i) {
				prime[j] = true;
			}
		}
		
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			
			int a = n/2;
			int b = n/2;
			
			while(true) {
				if(!prime[a] && !prime[b]) {
					System.out.println(a+" "+b+" ");
					break;
				}
				a--;
				b++;
			}
		}
	}
}
