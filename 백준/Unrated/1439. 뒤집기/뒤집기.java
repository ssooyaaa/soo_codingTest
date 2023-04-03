import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
        String s = br.readLine();
        int len = s.length();        
        int[] num = new int[len];
        int count = 0;
        
        for(int i=0;i<len;i++){
            num[i] = s.charAt(i)-'0';
        }
        
        for(int i=0;i<len-1;i++){
            if(num[i]!=num[i+1])
                count ++;
        }
        
        if(num[0]==num[len-1]){
            System.out.println(count/2);
        }else{
            System.out.println(count/2+1);
        }
        
        
        
    }

}