import java.util.*;
public class Main {
	
	static int dn(int n) {
		int sum = n;
		
		while(n!=0) {
			sum = sum + (n%10);
			n = n/10;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean[] check = new boolean[10001];
		
		for(int i=1;i<10001;i++) {
			int n = dn(i);
			
			if(n<10001) {
				check[n] = true;
			}
		}
		
		for(int i=1;i<10001;i++) {
			if(check[i]==false)
				System.out.println(i);
		}
		
	}

}
