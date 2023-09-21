import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String test = br.readLine();
			
			if(test.equals("end")) break;
			
			sb.append("<").append(test).append("> is ");
			if(!checking(test)) {
				sb.append("not ");
			}
			sb.append("acceptable.").append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean checking(String s) {
		char[] arr = s.toCharArray();
		List<Character> list = new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			list.add(arr[i]);
		}
		
		if(!haveMo(list)) return false;
		
		for(int i=2;i<arr.length;i++) {
			if(isMo(arr[i])) {
				if(isMo(arr[i-1])&&isMo(arr[i-2])) {
					return false;
				}
			}else {
				if(!isMo(arr[i-1])&&!isMo(arr[i-2])) {
					return false;
				}
			}
		}
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[i-1]) {
				if(arr[i] != 'e' && arr[i] != 'o')
					return false;
			}
		}
		
		return true;
	}
	
	static boolean haveMo(List<Character> list) {
		return (list.contains('a') || list.contains('e') || list.contains('i') || list.contains('o') || list.contains('u'));
	}
	
	static boolean isMo(Character c) {
		return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
	}
	
}