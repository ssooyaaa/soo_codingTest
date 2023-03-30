import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] a = new int[N];
        int[] b = new int[N];
        
                
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        List<Integer> bList = new ArrayList<>();
        for(int i=0;i<b.length;i++){
            bList.add(b[i]);
        }
        
        Arrays.sort(a);
        
        int answer = 0;
        
        for(int i=0;i<a.length;i++){
            int max = Collections.max(bList);
            answer += (a[i] * max);
            bList.remove(Integer.valueOf(max));
        }
        
        System.out.println(answer);
    }

}