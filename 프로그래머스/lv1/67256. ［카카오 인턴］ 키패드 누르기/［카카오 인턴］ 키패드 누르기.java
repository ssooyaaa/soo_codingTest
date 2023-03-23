import java.util.*;
class Solution {
    
    int[][] keypad = {{1,2,3},
                      {4,5,6},
                      {7,8,9},
                      {10,0,11}};
    int leftHand = 10;
    int rightHand = 11;   
    
    public String solution(int[] numbers, String hand) {
        
        StringBuilder builder = new StringBuilder();
        
        for(int num:numbers){
            
            if(num==1||num==4||num==7){
                leftHand=num;
                builder.append("L");
            }else if(num==3||num==6||num==9){
                rightHand=num;
                builder.append("R");
            }else{
                int[] leftP = getPosition(leftHand);
                int[] rightP = getPosition(rightHand);
                int[] desP = getPosition(num);
                
                int leftLength = Math.abs(leftP[0]-desP[0])+Math.abs(leftP[1]-desP[1]);
                int rightLength = Math.abs(rightP[0]-desP[0])+Math.abs(rightP[1]-desP[1]);
                
                if(leftLength>rightLength){
                    rightHand=num;
                    builder.append("R");
                }else if(leftLength<rightLength){
                    leftHand=num;
                    builder.append("L");
                }else{
                    if(hand.equals("left")){
                        leftHand=num;
                        builder.append("L");
                    }else{
                        rightHand=num;
                        builder.append("R");
                    }
                }
            }
        }
            
        
        
        return builder.toString();
    }
    
    //위치 반환
    public int[] getPosition(int num){
        int[] p = new int[]{0,0};
        
        for(int i=0;i<keypad.length;i++){
            for(int j=0;j<keypad[i].length;j++){
                if(keypad[i][j] == num){
                    p[0]=i;
                    p[1]=j;
                }
            }
        } return p;
    }
}