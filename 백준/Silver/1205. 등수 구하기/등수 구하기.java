import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int score = sc.nextInt();
        int P = sc.nextInt();
 
        int[] arr = new int[N];
        int rank = 1;
 
 
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
 
        if(N==P && score<=arr[arr.length-1])
            System.out.println(-1);
        else{
            for(int i=0; i<arr.length; i++){
                if(score < arr[i])
                    rank++;
                else
                    break;
            }
            System.out.println(rank);
        }
 
    }
}