import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int count, num;
	
	Node(int count, int num){
		this.count = count;
		this.num = num;
	}
	
	public int compareTo(Node o) {
		if(this.count > o.count) {
			return 1;
		}else if(this.count==o.count) {
			return this.num - o.num;
		}else
			return -1;
	}
}

public class Main {
	
	static int r,c,k;
	static int[][] matrix;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		
		matrix = new int[101][101];
		
		int R = 3;
		int C = 3;
		
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = -1;
		
		for(int i=0;i<=100;i++) {
			if(matrix[r][c]==k) {
				time = i;
				break;
			}
			
			//R
			if(R>=C) {
				int newC = 0;
				
				for(int j=0;j<R;j++) {
					Queue<Node> q1 = new PriorityQueue<>();
					
					int[] numCount = new int[101];
					
					for(int k=0;k<C;k++) {
						numCount[matrix[j][k]]++;
						matrix[j][k] = 0;
					}
					
					for(int m=1;m<101;m++) {
						if(numCount[m]>0) {
							q1.add(new Node(numCount[m],m));
						}
					}
					
					int index=0;
					while(!q1.isEmpty()) {
						matrix[j][index++]=q1.peek().num;
						matrix[j][index++]=q1.peek().count;
						q1.remove();
					}
					
					//R연산인 경우, 열길이만
					if(newC < index) {
						newC = index;
					}
				}
				C = newC;
			}
			//C연산
			else {
				int newR = 0;
				
				for(int j=0;j<C;j++) {
					Queue<Node> q2 = new PriorityQueue<>();
					
					int[] numCount = new int[101];
					
					for(int k=0;k<R;k++) {
						numCount[matrix[k][j]]++;
						matrix[k][j]=0;
					}
					
					for(int m=1;m<101;m++) {
						if(numCount[m]!=0) {
							q2.add(new Node(numCount[m],m));
						}
					}
					
					int index=0;
					while(!q2.isEmpty()) {
						matrix[index++][j] = q2.peek().num;
						matrix[index++][j] = q2.peek().count;
						q2.remove();
					}
					
					if(newR < index) {
						newR = index;
					}
				}
				R = newR;
			}
		}
		System.out.println(time);
	}
	
}
