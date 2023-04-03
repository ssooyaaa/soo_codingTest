import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
      
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(sc.nextInt());
        }
        
        if(n==1)
            System.out.println(0);
        else{
            int total = 0;
            while(pq.size()>1){
                int num1 = pq.remove();
                int num2 = pq.remove();
                total += num1 + num2;
                pq.add(num1+num2);
            }
            
            System.out.println(total);
        }
        
    }

}