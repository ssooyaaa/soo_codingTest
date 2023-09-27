import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int pole = 64;
		
		List<Integer> list = new ArrayList<>();
		list.add(pole);
		
		while(pole>0) {
			list.add(pole/2);
			pole /= 2;
		}
		
		int total=0;
		int count=0;
		
		if(x!=total) {
			for(int i=0;i<list.size();i++) {
				if(x>=total+list.get(i)) {
					total = total+list.get(i);
					count++;
				}
			}
			System.out.println(count-1);
		}
	}

}