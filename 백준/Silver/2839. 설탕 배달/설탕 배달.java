import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int total = 0;
		
		while(true) {
			if(n%5 == 0) {
				System.out.println(n/5 + total);
				break;
			} else if(n<0) {
				System.out.println(-1);
				break;
			}
			n -= 3;
			total++;
		}	
		sc.close();
		
	}
	

}