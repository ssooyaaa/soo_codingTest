class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, Integer.MAX_VALUE};
        
        int sum = 0;
        int left = 0, right = 0;
        
        while(true){
            while(sum < k && right<sequence.length){
                sum += sequence[right++];
            }
            if(sum==k){
                if(answer[1]-answer[0]>right-left-1){
                    answer[0] = left;
                    answer[1] = right-1;
                }
            }
            
            sum -= sequence[left++];
            if(sum == k){
                if(answer[1]-answer[0]>right-left-1){
                    answer[0]=left;
                    answer[1]=right-1;
                }
            }
            
            if(left==sequence.length) break;
        }
        return answer;
    }
}