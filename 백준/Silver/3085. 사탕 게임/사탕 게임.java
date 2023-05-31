import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[][] arr;
	static int max;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				char temp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = temp;
				
				check(arr);
				
				temp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = temp;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				char temp = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = temp;
				
				check(arr);
				
				temp = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = temp;
			}
		}
		System.out.println(max);
	}
	
	public static void check(char[][] arr) {
		for(int i=0;i<N;i++) {
			int count = 1;
			for(int j=0;j<N-1;j++) {
				if(arr[i][j]==arr[i][j+1]) {
					count++;
				}else {
					count = 1;
				}
				max = Math.max(max, count);
			}
		}
		
		for(int i=0;i<N;i++) {
			int count = 1;
			for(int j=0;j<N-1;j++) {
				if(arr[j][i] == arr[j+1][i]) {
					count++;
				}else {
					count = 1;
				}
				max = Math.max(max, count);
			}
		}
	}
	
}

