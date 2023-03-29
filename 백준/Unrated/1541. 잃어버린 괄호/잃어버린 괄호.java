import java.util.*;

public class Main{
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
        
        int sum = Integer.MAX_VALUE;
        
        String[] nums = sc.nextLine().split("-");
        
        for(int i=0;i<nums.length;i++){
            String[] add = nums[i].split("\\+");
            int temp = 0;
            
            for(int j=0;j<add.length;j++){
                temp += Integer.parseInt(add[j]);
            }
            
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }else{
                sum -= temp;
            }
        } System.out.println(sum);
	}

}