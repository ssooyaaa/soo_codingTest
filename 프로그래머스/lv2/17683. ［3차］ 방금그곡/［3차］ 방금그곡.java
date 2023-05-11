import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxTime = -1;
        
        m = change(m);
        
        for(String music : musicinfos){
            String[] info = music.split(",");
            String title = info[2];
            
            String melodyInfo = change(info[3]);
            
            String[] time = info[0].split(":");
            int start = Integer.valueOf(time[0])*60 + Integer.valueOf(time[1]);
            
            
            time = info[1].split(":");
            int end = Integer.valueOf(time[0])*60 + Integer.valueOf(time[1]);
            
            int play = end-start;
            
            if(play>melodyInfo.length()){
                StringBuilder newMelody = new StringBuilder();
                
                for(int i=0;i<play/melodyInfo.length();i++){
                    newMelody.append(melodyInfo);
                }    
                    newMelody.append(melodyInfo.substring(0,play%melodyInfo.length()));
                    melodyInfo = newMelody.toString();
                
            }else{
                melodyInfo = melodyInfo.substring(0, play);
                
            }
            
            if(melodyInfo.contains(m) && play>maxTime){
                answer = title;
                maxTime = play;
            }
        }
        
        return maxTime != -1? answer : "(None)";
    }
    
    String change(String melody){
        melody = melody.replaceAll("C#","c");
        melody = melody.replaceAll("D#","d");
        melody = melody.replaceAll("F#","f");
        melody = melody.replaceAll("G#","g");
        String newMelody = melody.replaceAll("A#","a");
        
        return newMelody;
    }
}