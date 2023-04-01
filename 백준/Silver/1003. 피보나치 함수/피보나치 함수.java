import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        
        int[] arr = new int[T];
        
        for(int i=0;i<T;i++){
            arr[i] = sc.nextInt();
        }
        
        int[] zero = new int[41];
        int[] one = new int[41];
        
        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;
        
        for(int i=2;i<41;i++){
            zero[i] = zero[i-1]+zero[i-2];
            one[i] = one[i-1]+one[i-2];
        }
        
        for(int i=0;i<T;i++){
            System.out.println(zero[arr[i]]+" "+one[arr[i]]);
        }
    }

}