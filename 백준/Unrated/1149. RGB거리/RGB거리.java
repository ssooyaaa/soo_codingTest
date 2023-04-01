import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException{
	
		Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(); 
        
        int[][] home = new int[n+1][3];
        
        for(int i=1;i<n+1;i++){
            int red = sc.nextInt();
            int green = sc.nextInt();
            int blue = sc.nextInt();
            
            home[i][0] = Math.min(home[i-1][1],home[i-1][2])+red;
            home[i][1] = Math.min(home[i-1][0],home[i-1][2])+green;
            home[i][2] = Math.min(home[i-1][0],home[i-1][1])+blue;
        }
        
        System.out.println(Math.min(home[n][0],Math.min(home[n][1],home[n][2])));
		
	}

}