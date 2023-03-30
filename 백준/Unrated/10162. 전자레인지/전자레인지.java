import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
        int a=0;
        int b=0;
        int c=0;
        
        if(time>=300){
            a = time/300;
            time -= 300*a;
        }
        
        if(time>=60){
            b = time/60;
            time -= 60*b;
        }
        
        if(time%10!=0){
            System.out.println(-1);
        }else{
            c = time/10;
            System.out.println(a+" "+b+" "+c);
        }
    }

}