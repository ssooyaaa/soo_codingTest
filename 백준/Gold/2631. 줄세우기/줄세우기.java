import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] student = new int[N];
		for(int i=0;i<N;i++) {
			student[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N];
		dp[0] = 1;
		
		int max = 0;
		for(int i=1;i<N;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(student[j]<student[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(N-max);
	}
	
}