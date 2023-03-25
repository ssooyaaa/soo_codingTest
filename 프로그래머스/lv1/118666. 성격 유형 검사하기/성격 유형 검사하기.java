import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("R",0);
        map.put("T",0);
        map.put("C",0);
        map.put("F",0);
        map.put("J",0);
        map.put("M",0);
        map.put("A",0);
        map.put("N",0);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<survey.length;i++){
            String[] arr = survey[i].split("");
            if(choices[i]<4){
                map.put(arr[0],map.getOrDefault(arr[0],0)+4-choices[i]);
            }else if(choices[i]==4){
                continue;
            }else if(choices[i]>4){
                map.put(arr[1],map.getOrDefault(arr[1],0)+choices[i]-4);
            }
        }
        
        if(map.get("R")>=map.get("T"))
            sb.append("R");
        else
            sb.append("T");
        
        if(map.get("C")>=map.get("F"))
            sb.append("C");
        else
            sb.append("F");
        
        if(map.get("J")>=map.get("M"))
            sb.append("J");
        else
            sb.append("M");
        
        if(map.get("A")>=map.get("N"))
            sb.append("A");
        else
            sb.append("N");
       
        return sb.toString();
    }
}