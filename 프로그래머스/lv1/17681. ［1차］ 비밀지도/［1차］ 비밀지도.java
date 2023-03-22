class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];
        
        for(int i=0;i<n;i++){
            int[] map1 = binary(n,arr1[i]);
            int[] map2 = binary(n,arr2[i]);
            
            StringBuilder builder = new StringBuilder();
            
            for(int j=0;j<n;j++){
                if(map1[j]==1 || map2[j]==1){
                    builder.append("#");
                }else{
                    builder.append(" ");
                }
            }
            map[i] = builder.toString();
        }
        
        
        return map;
    }
    
    public int[] binary(int n, int num){
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[n-i-1] = num%2;
            
            num /= 2;
        }
        
        return arr;
    }
}