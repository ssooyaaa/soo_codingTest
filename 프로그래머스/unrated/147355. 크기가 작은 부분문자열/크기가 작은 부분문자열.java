class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        String subS = "";
        
        for(int i=0;i<t.length()-pLen+1;i++){
            subS = t.substring(i,i+pLen);
            if(Long.parseLong(subS)<=Long.parseLong(p))
                answer ++;
        }
        return answer;
    }
}