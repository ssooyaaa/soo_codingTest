import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
        
        int cost = sc.nextInt();
        int[] arr = {500,100,50,10,5,1};
        cost = 1000-cost;
        int count = 0;
        
        for(int i=0;i<arr.length;i++){
            if(cost/arr[i]>0){
                count += cost/arr[i];
                cost = cost%arr[i];
            }
        }
        
        System.out.println(count);
        
    }

}