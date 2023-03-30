import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
	    
        Long s = sc.nextLong();
        int n=0;
        while(s>0){
            s -= ++n;
        }
        
        System.out.println(s==0?n:n-1);
    }

}