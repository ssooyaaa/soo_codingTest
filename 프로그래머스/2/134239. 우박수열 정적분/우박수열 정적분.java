import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        int count = getCount(k);
        
        double[] y = new double[count+1];
        y[0] = k;
        for(int i=1;i<count+1;i++){
            double pre = y[i-1];
            y[i] = calY(pre);
        }
        
        double[] area = new double[count+1];
        for(int i=1;i<count+1;i++){
            area[i] = (y[i-1]+y[i])/2;
        }
        
        double[] sum = new double[count+1];
        sum[1] = area[1];
        for(int i=2;i<count+1;i++){
            sum[i] = (area[i]+sum[i-1]);
        }
        
        for(int i=0;i<ranges.length;i++){
            int s = ranges[i][0];
            int e = count+ranges[i][1];
            
            if(s<e){
                double val = sum[e]-sum[s];
                String st = String.format("%.1f",val);
                answer[i] = (Double.parseDouble(st));
           }else if(s>e){
                answer[i] = -1.0;
            }else
                answer[i] = 0.0;
        }
        
        return answer;
    }
    
    static int getCount(int y){
        int count = 0;
        while(y>1){
            if(y%2==0) y=y/2;
            else y = (y*3)+1;
            count++;
        }
        
        return count;
    }
    
    static double calY(double pre){
        if(pre%2==0) return pre/2;
        else return 3*pre+1;
    }
}