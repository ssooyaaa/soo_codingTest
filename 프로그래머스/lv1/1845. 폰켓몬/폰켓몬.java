import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<Integer>();
	        list.add(nums[0]);

	        for(int i=0;i<nums.length;i++){
	            if(!list.contains(nums[i])){
	                list.add(nums[i]);
	            }
	        }

	        if(list.size()< nums.length/2){
	            answer = list.size();
	        }else{
	            answer = nums.length/2;
	        }

	        return answer;
    }
}