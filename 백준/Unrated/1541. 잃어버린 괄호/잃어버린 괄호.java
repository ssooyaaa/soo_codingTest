import java.util.*;

public class Main{
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
        
	//초기값 0이 아닌 Integer.MAX_VALUE를 사용한 이유 : 중간 계산 or 결과로 나오지 않는 수로 초기화
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
