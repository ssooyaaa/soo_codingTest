import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            public int compare(String s1, String s2){
                String[] file1 = fileName(s1);
                String[] file2 = fileName(s2);
                
                int headValue = file1[0].compareTo(file2[0]);
                
                if(headValue==0){
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);
                    
                    return num1-num2;
                }else{
                    return headValue;
                }
            }
            
            public String[] fileName(String s){
                String head = "";
                String number = "";
                String tail = "";
                
                int idx = 0;
                for(;idx<s.length();idx++){
                    char ch = s.charAt(idx);
                    if(ch >='0' && ch<='9') break;
                    head += ch;
                }
                
                for(;idx<s.length();idx++){
                    char ch = s.charAt(idx);
                    if(!(ch>='0' && ch<='9')) break;
                    number += ch;
                }
                
                for(;idx<s.length();idx++){
                    char ch = s.charAt(idx);
                    tail += ch;
                }
                
                String[] file = {head.toLowerCase(), number, tail};
                
                return file;
            }
        });
        return files;
    }
}