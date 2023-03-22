class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] arr = new int[3];
        int index = 0;
        String num = "";
        
            for(int i=0;i<dartResult.length();i++){
                switch(dartResult.charAt(i)){
                    case 'S':
                        arr[index] = (int)Math.pow(Integer.parseInt(num),1);
                        index++;
                        num = "";
                        break;
                    case 'D':
                        arr[index] = (int)Math.pow(Integer.parseInt(num),2);
                        index++;
                        num = "";
                        break;
                    case 'T':
                        arr[index] = (int)Math.pow(Integer.parseInt(num),3);
                        index++;
                        num = "";
                        break;

                    case '*':
                        arr[index-1]*=2;
                        if(index>1)
                            arr[index-2]*=2;
                        break;
                    case '#':
                        arr[index-1]*=-1;
                        break;
                    default:
                        num+=String.valueOf(dartResult.charAt(i));
                        break;
                }

            }
        
            for(int i=0;i<arr.length;i++){
                answer+=arr[i];
            }
        
        return answer;
        
        }

    
}