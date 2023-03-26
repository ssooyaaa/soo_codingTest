import java.util.*;
class Solution {
    int[] position;
    boolean[] visited;
    int count;
    HashMap<Character, Integer> fr;
    
    
    public int solution(int n, String[] data) {
        int answer = 0;
        position = new int[8];
        visited = new boolean[8];
        count = 0;
        fr = new HashMap<>();
        
        fr.put('A',0);
        fr.put('C',1);
        fr.put('F',2);
        fr.put('J',3);
        fr.put('M',4);
        fr.put('N',5);
        fr.put('R',6);
        fr.put('T',7);
        
        perm(0,data);
        answer = count;
        
        return answer;
    }
    
    //순열
    public void perm(int index, String[] data){
        if(index == 8){
            if(dataCheck(data)){
                count ++;
            } return;
        }
        
        for(int i=0;i<8;i++){
            if(!visited[i]){
                visited[i] = true;
                position[index] = i;
                perm(index+1, data);
                visited[i] = false;
            }
        }
    }
    
    public boolean dataCheck(String[] data){
        for(int i=0;i<data.length;i++){
            int X = fr.get(data[i].charAt(0));
            int Y = fr.get(data[i].charAt(2));
            char type = data[i].charAt(3);
            int dif = data[i].charAt(4)-'0';
            int Xpos = position[X];
            int Ypos = position[Y];
            
            if(type=='='){
                if(Math.abs(Xpos-Ypos)-1 != dif)
                    return false;
            } else if(type == '>'){
                if(Math.abs(Xpos-Ypos)-1 <= dif)
                    return false;
            }else if(type == '<'){
                if(Math.abs(Xpos-Ypos)-1 >= dif)
                    return false;
            }
        } return true;
    }
}