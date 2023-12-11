import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String A = st.nextToken();
        String B = st.nextToken();
        
        StringBuilder Amin = new StringBuilder();
        StringBuilder Amax = new StringBuilder();
        for(int i=0;i<A.length();i++) {
        	if(A.charAt(i)=='6') {
        		Amin.append(5);
        		Amax.append(6);
        	}else if(A.charAt(i)=='5'){
        		Amin.append(5);
        		Amax.append(6);
        	}else {
        		Amin.append(A.charAt(i));
        		Amax.append(A.charAt(i));
        	}
        		
        }
        
        StringBuilder Bmin = new StringBuilder();
        StringBuilder Bmax = new StringBuilder();
        for(int i=0;i<B.length();i++) {
        	if(B.charAt(i)=='6') {
        		Bmin.append(5);
        		Bmax.append(6);
        	}else if(B.charAt(i)=='5'){
        		Bmin.append(5);
        		Bmax.append(6);
        	}else {
        		Bmin.append(B.charAt(i));
        		Bmax.append(B.charAt(i));
        	}
        		
        }
        
        int min = Integer.parseInt(Amin.toString())+Integer.parseInt(Bmin.toString());
        int max = Integer.parseInt(Amax.toString())+Integer.parseInt(Bmax.toString());
        
        System.out.println(min+" "+max);
        
    }
}
