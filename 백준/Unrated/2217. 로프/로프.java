import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
        int[] rope = new int[n];
        
        for(int i=0;i<n;i++){
            rope[i] = sc.nextInt();
        }
        
        Arrays.sort(rope);
        
        int total = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            total = Math.max(total, rope[i]*(n-i));
        }
        
        System.out.println(total);
    }

}