import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		
		int Alen = A.length;
		int Blen = B.length;
		
		int[][] dp = new int[Alen+1][Blen+1];
		
		for(int i=1;i<=Alen;i++) {
			for(int j=1;j<=Blen;j++) {
				if(A[i-1] == B[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[Alen][Blen]);
		
	}
	
}