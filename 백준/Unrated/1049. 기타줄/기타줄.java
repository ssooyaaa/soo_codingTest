import java.util.*;
public class Main {
	
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] setPrice = new int[m];
		int[] price = new int[m];
		
		for(int i=0;i<m;i++) {
			setPrice[i] = sc.nextInt();
			price[i] = sc.nextInt();
		}
		
		Arrays.sort(setPrice);
		Arrays.sort(price);
		
		int totalCost = Integer.MAX_VALUE;
		
		totalCost = Math.min((n/6+1)*setPrice[0], n*price[0]);
		totalCost = Math.min(totalCost, ((n/6)*setPrice[0]+(n%6)*price[0]));
		
		
		System.out.println(totalCost);
		
		
	}	
	
}