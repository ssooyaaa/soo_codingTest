import java.util.*;

public class Main{
	public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[][] arr = new int[n][2];
        
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt(); 
        }
        
        Arrays.sort(arr, new Comparator<int[]>(){
            
            @Override
            public int compare(int[] a1, int[] a2){
                if(a1[1] == a2[1]){
                    return a1[0] - a2[0];
                }                
                return a1[1]-a2[1];
            }
        });
        
        int count = 0;
        int pre_end = 0;
        
        for(int i=0;i<n;i++){
            if(pre_end <=arr[i][0]){
                pre_end = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
	}

}