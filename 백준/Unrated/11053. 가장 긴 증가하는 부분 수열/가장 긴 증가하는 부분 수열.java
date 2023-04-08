import java.util.*;
public class Main {
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int[] seq = new int[n];
    	int[] dp = new int[n];
    	
    	for(int i=0;i<n;i++) {
    		seq[i] = sc.nextInt();
    	}
    	
    	for(int i=0;i<n;i++) {
    		dp[i]=1;
    		
    		for(int j=0;j<i;j++) {
    			if(seq[j]<seq[i] && dp[i]<dp[j]+1) {
    				dp[i] = dp[j]+1;
    			}
    		}
    	}
    	
    	int max = Integer.MIN_VALUE;
    	for(int i=0;i<n;i++) {
    		max = dp[i]>max? dp[i]:max;
    	}
        System.out.println(max);
    }
    
	
}