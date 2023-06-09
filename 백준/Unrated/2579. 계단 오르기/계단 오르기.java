import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
        
        int[] stair = new int[n+1];
        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++){
            stair[i] = sc.nextInt();
        }
        
        if(n==1){
            dp[1] = stair[1];
        } else if(n==2){
            dp[2] = stair[2]+stair[1];
        }else{
            dp[1] = stair[1];
            dp[2] = stair[1]+stair[2];
            dp[3] = Math.max(stair[1]+stair[3],stair[2]+stair[3]);
        
            for(int i=4;i<=n;i++){
                dp[i] = Math.max(dp[i-2]+stair[i],dp[i-3]+stair[i-1]+stair[i]);
            }
        }
        
        System.out.println(dp[n]);
    }

}