import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException{
	    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int[] num = new int[10];
        int sum = 0;
        
        for(int i=0;i<s.length();i++){
            int temp = s.charAt(i)-'0';
            num[temp] += 1;
            sum += temp;
        }
        if(s.contains("0") && sum%3==0){
            for(int i=9;i>=0;i--){
                while(num[i]>0){
                    System.out.print(i);
                    num[i]--;
                }
            }
        }else{
            System.out.println(-1);
        }
    }

}