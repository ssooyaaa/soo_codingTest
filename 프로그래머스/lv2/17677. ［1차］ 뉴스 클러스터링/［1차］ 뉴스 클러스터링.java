import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i=0;i<str1.length()-1;i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            
            if(a>='a' && a<='z' && b>='a' && b<='z'){
                list1.add(a+""+b);
            }
        }
        
        for(int i=0;i<str2.length()-1;i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            
            if(a>='a' && a<='z' && b>='a' && b<='z'){
                list2.add(a+""+b);
            }
        }
        
        for(String s : list1){
            if(list2.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }
        
        for(String s : list2){
            union.add(s);
        }
        
        double answer = 0;
        if(union.size()==0){
            answer = 1;
        }else{
            answer = (double)intersection.size()/(double)union.size();
        }
        return (int)(answer*65536);
    }
}