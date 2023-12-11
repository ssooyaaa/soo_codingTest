import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String board = br.readLine();
        
        String answer = poliomino(board);
        System.out.println(answer);
    }
    
    public static String poliomino(String board) {
    	String st = "";
    	
    	board = board.replaceAll("XXXX", "AAAA");
    	st = board.replaceAll("XX", "BB");
    	
    	if(st.contains("X"))
    		st = "-1";
    	
    	return st;
    }
}