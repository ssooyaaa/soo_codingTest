import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0;i<T;i++){
            Map<Integer, Integer> map = new HashMap<>();
            
            int count = 0;
            
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            
            for(int j=0;j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int score1 = Integer.parseInt(st.nextToken());
                int score2 = Integer.parseInt(st.nextToken());
                map.put(score1,score2);
                arr[j]=score1;
            }
            
            Arrays.sort(arr);
            
            int val = Integer.MAX_VALUE;
            
            for(int j=0;j<arr.length;j++){
                if(val>map.get(arr[j])){
                    val = map.get(arr[j]);
                    count++;
                }
            }System.out.println(count);
        }
		
	}

}