class Solution {
    static int answer = -1;
    
    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }
    
    static void dfs(int n, int num, int count, int val){
        if(count>8) return;
        
        if(num==val){
            if(answer>count || answer==-1)
                answer = count;
            return;
        }
        
        int nn = 0;
        for(int i=0;i<8;i++){
            nn = nn*10+n;
            
            dfs(n,num,count+1+i,val+nn);
            dfs(n,num,count+1+i,val-nn);
            dfs(n,num,count+1+i,val*nn);
            dfs(n,num,count+1+i,val/nn);
        }
    }
    
}