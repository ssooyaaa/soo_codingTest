import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		List<Character> korea = new ArrayList<>();
		List<Character> yon = new ArrayList<>();
		
		korea.add('K');
		korea.add('O');
		korea.add('R');
		korea.add('E');
		korea.add('A');
		
		yon.add('Y');
		yon.add('O');
		yon.add('N');
		yon.add('S');
		yon.add('E');
		yon.add('I');
		
		for(int i=0;i<s.length();i++) {
			if(korea.contains(s.charAt(i))) {
				int idx = korea.indexOf(s.charAt(i));
				korea.remove(idx);
				if(korea.size()==0) {
					System.out.println("KOREA");
					break;
				}
			}
			
			if(yon.contains(s.charAt(i))) {
				int idx = yon.indexOf(s.charAt(i));
				yon.remove(idx);
				if(yon.size()==0) {
					System.out.println("YONSEI");
					break;
				}
			}
		}
		
    }
	
	
}