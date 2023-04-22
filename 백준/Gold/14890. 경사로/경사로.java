import java.util.*;
import java.io.*;

public class Main {
	
	static int N,L;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
				
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		for(int i=0;i<N;i++) {
			if(canRow(i)) count++;
			if(canCol(i)) count++;
		}
		
		System.out.println(count);
    }
	
	public static boolean canRow(int row) {
		boolean[] isCline = new boolean[N];
		
		for(int i=0;i<N-1;i++) {
			int dif = map[row][i] - map[row][i+1];
			
			if(dif>1 || dif<-1) return false;
			else if(dif == -1) {
				for(int j=0;j<L;j++) {
					if(i-j<0 || isCline[i-j]) return false;
					if(map[row][i]!=map[row][i-j]) return false;
					isCline[i-j] = true;
				}
			}else if(dif == 1) {
				for(int j=1;j<=L;j++) {
					if(i+j>=N || isCline[i+j]) return false;
					if(map[row][i]-1 != map[row][i+j]) return false;
					isCline[i+j] = true;
				}
			}
		}
		return true;
		
	}
	
	
	public static boolean canCol(int col) {
		boolean[] isCline = new boolean[N];
		
		for(int i=0;i<N-1;i++) {
			int dif = map[i][col] - map[i+1][col];
			
			if(dif>1 || dif<-1) return false;
			else if(dif == -1) {
				for(int j=0;j<L;j++) {
					if(i-j<0 || isCline[i-j]) return false;
					if(map[i][col]!=map[i-j][col]) return false;
					isCline[i-j] = true;
				}
			}else if(dif == 1) {
				for(int j=1;j<=L;j++) {
					if(i+j>=N || isCline[i+j]) return false;
					if(map[i][col]-1 != map[i+j][col]) return false;
					isCline[i+j] = true;
				}
			}
		}
		return true;
	}
	
	
	  
    
}