class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        
        int length = arr.length;
       
        QuadTree(arr,0,0,length);
        
        return answer;
    }
    
    public void QuadTree(int[][] arr, int x, int y, int length){
        if(check(arr, x, y, length)){
            answer[arr[x][y]]++;
            return;
        }
        
        QuadTree(arr, x, y, length/2);
        QuadTree(arr, x+length/2, y, length/2);
        QuadTree(arr, x, y+length/2, length/2);
        QuadTree(arr, x+length/2, y+length/2, length/2);
    }
    
    public boolean check(int[][] arr, int x, int y, int length){
        for(int i=x;i<x+length;i++){
            for(int j=y;j<y+length;j++){
                if(arr[i][j]!=arr[x][y])
                    return false;
            }
        }
        return true;
    }
}