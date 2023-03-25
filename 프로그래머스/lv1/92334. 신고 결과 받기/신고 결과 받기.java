import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //유저 순서
        HashMap<String,Integer> userMap = new HashMap<>();
        //자신을 신고한 유저 저장
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        for(int i=0;i<id_list.length;i++){
            userMap.put(id_list[i],i);
            map.put(id_list[i],new HashSet<>());
        }
        
        //지신을 신고한 유저 저장
        for(int i=0;i<report.length;i++){
            String[] s = report[i].split(" ");
            map.get(s[1]).add(s[0]);
        }
        
        //메일 보내기
        for(int i=0;i<id_list.length;i++){
            HashSet<String> set = map.get(id_list[i]);
            if(set.size()>=k){
                for(String userId:set){
                    answer[userMap.get(userId)]++;
                }
            }
        }
        
        return answer;
    }
}