import java.util.*;

public class Main{
    static int a,b,dp[];
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        dp = new int[n+1];
        dp[1]=1;
        dp[2]=1;
        fib(n);
        
        fibonacci(n);
        
        System.out.println(a+" "+b);
	}
    
    public static int fib(int n){
        if(n==1||n==2){
            a++;
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
    
    public static int fibonacci(int n){
        for(int i=3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
            b++;
        }
        return dp[n];
    }

}