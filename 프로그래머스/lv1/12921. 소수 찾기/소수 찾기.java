class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] num = new boolean[n+1];
        
        for(int i=2;i<n+1;i++){
            num[i]=true;
        }
        
        int root = (int)Math.sqrt(n);
        
        for(int i=2;i<root+1;i++){
            if(num[i]==true){
                for(int j=i;i*j<n+1;j++)
                    num[i*j]=false;
            }
        }
        
        for(int i=2;i<n+1;i++){
            if(num[i]==true)
                answer++;
        }
        
        return answer;
    }
}