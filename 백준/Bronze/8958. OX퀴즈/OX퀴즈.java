import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String arr[] = new String[n];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.next();
		}
		
		sc.close();
		
		for(int i=0;i<arr.length;i++) {
			int count = 0;
			int sum = 0;
			
			for(int j=0;j<arr[i].length();j++) {
				if(arr[i].charAt(j)=='O')
					count++;
				else {
					count = 0;
				}
				sum += count;
			}
			
			System.out.println(sum);
		}
	}

}
