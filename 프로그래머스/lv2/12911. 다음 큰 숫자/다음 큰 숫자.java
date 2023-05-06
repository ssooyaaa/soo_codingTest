class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String binary = Integer.toString(n,2);
        int count = 0;
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1') count++;
        }
        
        for(int i=n+1;i<1000000;i++){
            String temp = Integer.toString(i,2);
            int temp_count = 0;
            for(int j=0;j<temp.length();j++){
                if(temp.charAt(j)=='1') temp_count++;
            }
            
            if(temp_count == count){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}