import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			int count = Integer.parseInt(st.nextToken());
			
			for(int j=1;j<=N;j++) {
				if(count==0) {
					if(arr[j]==0) {
						arr[j]=i;
						break;
					}else {
						continue;
					}
				}else if(arr[j]==0) {
					count--;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
}

