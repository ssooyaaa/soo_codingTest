import java.util.*;
public class Main {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		int count = 0;
		while(n>3) {
			count++;
			n = n/2 + (n%2==1? 1:0);
		}
		System.out.println(count + n);
		
		
    }
	
	
}