class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int gcd = num(Math.max(n,m), Math.min(n,m));
        
        answer[0] = gcd;
        answer[1] = n*m/gcd;
        
        return answer;
    
   
    }
    
    //최대공약수
    public int num(int a, int b){
        if(a%b==0)
            return b;
        return num(b, a%b);
    }
}