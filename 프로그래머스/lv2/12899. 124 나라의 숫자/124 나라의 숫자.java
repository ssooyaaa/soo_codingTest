class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb= new StringBuilder();
        
        while(n != 0){
            if(n%3==0){
                sb.append(4);
                n = n/3 - 1;
            }else{
                sb.append(n%3);
                n /= 3;
            }
        }
        
        answer = sb.reverse().toString();
        return answer;
    }
}