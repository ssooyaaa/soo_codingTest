class Solution {
    public long solution(int n) {
        long[] dp = new long[2001];
        
        dp[1] = 1L;
        dp[2] = 2L;
        
        for(int i=3;i<2001;i++){
            dp[i] = (dp[i-2]+dp[i-1])%1234567;
        }
        
        return dp[n];
    }
}