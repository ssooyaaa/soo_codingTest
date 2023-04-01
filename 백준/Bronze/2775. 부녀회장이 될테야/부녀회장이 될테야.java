import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			int klayer = sc.nextInt();
			int nho = sc.nextInt();
			
			int[][] apart = new int [15][15];
			
			for(int i=1;i<15;i++) {
				apart [0][i] = i;
			}
			
			for(int i=1;i<15;i++) {
				apart[i][1] = 1;
			}
			
			for(int i=1;i<15;i++) {
				for(int j=1;j<15;j++) {
					apart[i][j] = apart[i-1][j] + apart[i][j-1];
				}
			}	
			System.out.println(apart[klayer][nho]);
		}
		sc.close();
		
	}
	

}
