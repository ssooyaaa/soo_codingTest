class Solution {
    
    boolean[] checked;
    int answer;
    
    public int solution(String begin, String target, String[] words) {
        
        answer = 0;
        
        checked = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int count){
        
        if(begin.equals(target)){
            answer = count;
            return;
        }
        
        for(int i=0;i<words.length;i++){
            
            if(checked[i]) continue;
            
            int sameWord = 0;
            for(int j=0;j<begin.length();j++){
                if(begin.charAt(j)==words[i].charAt(j)) sameWord++;
            }
            
            
            if(sameWord==begin.length()-1){
                checked[i] = true;
                dfs(words[i], target, words, count+1);
                checked[i] = false;
            }
            
        }
    }
}