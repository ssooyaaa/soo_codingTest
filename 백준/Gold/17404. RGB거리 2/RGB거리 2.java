import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int INF = 1000*1000;
		int sum = INF;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j=0;j<3;j++) {
			for(int i=0;i<3;i++) {
				if(i==j) dp[1][i] = arr[1][i];
				else dp[1][i] = INF;
			}
			
			for(int i=2;i<=N;i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+arr[i][2];
			}
			
			for(int i=0;i<3;i++) {
				if(i!=j) sum = Math.min(dp[N][i], sum);
			}
		}
		
		System.out.println(sum);
		
	}
	
}