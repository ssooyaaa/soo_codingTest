import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] gear;
	static int sum=0;
	static int[] dir;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gear = new int[4][8];
		
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) {
				gear[i][j] = s.charAt(j)-'0';
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken())-1;
			int turn = Integer.parseInt(st.nextToken());
			
			dir = new int[4];
			
			dir[num] = turn;
			checkDir(num);
			gearTurn();
		}
		
		if(gear[0][0] == 1) sum+=1;
		if(gear[1][0] == 1) sum+=2;
		if(gear[2][0] == 1) sum+=4;
		if(gear[3][0] == 1) sum+=8;
		System.out.println(sum);
		
	}
	
	static void checkDir(int num) {
		for(int i=num-1;i>=0;i--) {
			if(gear[i][2] != gear[i+1][6]) {
				dir[i] = -dir[i+1];
			}else {
				break;
			}
		}
		
		for(int i=num+1;i<4;i++) {
			if(gear[i][6] != gear[i-1][2]) {
				dir[i] = -dir[i-1];
			}else {
				break;
			}
		}
	}
	
	static void gearTurn() {
		int temp=0;
		
		for(int i=0;i<4;i++) {
			if(dir[i] == 1) {
				temp = gear[i][7];
				for(int j=7;j>0;j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = temp;
			}
			
			if(dir[i] == -1) {
				temp = gear[i][0];
				for(int j=0;j<7;j++) {
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = temp;
			}
		}
	}
}
