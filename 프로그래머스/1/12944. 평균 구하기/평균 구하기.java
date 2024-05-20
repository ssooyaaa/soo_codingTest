class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        int count = arr.length;
        int sum = 0;
        
        for(int i=0;i<count;i++){
            sum += arr[i];
        }
        
        answer = (double)sum/count;
        
        return answer;
    }
}