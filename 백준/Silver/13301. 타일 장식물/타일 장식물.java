import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] fibo = new long[81];
		fibo[1] = 1;
		fibo[2] = 1;
		for(int i=3;i<=N;i++) {
			fibo[i] = fibo[i-2]+fibo[i-1];
		}
		
		long[][] dp = new long[N+1][2];
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for(int i=2;i<=N;i++) {
			if(i%2==0) {
				dp[i][0] = dp[i-1][0];
				dp[i][1] = dp[i-1][1]+fibo[i];
			}else {
				dp[i][0] = dp[i-1][0]+fibo[i];
				dp[i][1] = dp[i-1][1];
			}
		}
		
		System.out.println((dp[N][0]+dp[N][1])*2);
	}
	
}
