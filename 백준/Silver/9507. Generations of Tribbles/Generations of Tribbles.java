import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		long[] koong = new long[68];
		for(int i=0;i<2;i++) {
			koong[i] = 1;
		}
		koong[2] = 2;
		koong[3] = 4;
		
		while(T-->0) {
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i=4;i<=N;i++) {
				koong[i] = koong[i-1]+koong[i-2]+koong[i-3]+koong[i-4];
			}
			
			System.out.println(koong[N]);
		}
		
	}
	
}