import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] paper;
	static int white=0;
	static int blue=0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		QuadPaper(0,0,n);
		
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	static void QuadPaper(int x, int y, int size) {
		if(color(x, y, size)) {
			if(paper[x][y]==0) {
				white++;
			}else {
				blue++;
			}
			return;
		}
		
		int newSize = size/2;
		
		QuadPaper(x, y, newSize);
		QuadPaper(x, y+newSize, newSize);
		QuadPaper(x+newSize, y, newSize);
		QuadPaper(x+newSize, y+newSize, newSize);
	}
	
	static boolean color(int x, int y, int size) {
		int val = paper[x][y];
		
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(paper[i][j]!=val)
					return false;
			}
		}
		
		return true;
	}

}
