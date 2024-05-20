class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        
        int sum = 0;
        int xx = x;
        
        while(xx>=1){
            sum += xx%10;
            xx = xx/10;
        }
        
        sum += xx;
        
        if(x%sum==0) answer = true;
        
        return answer;
    }
}