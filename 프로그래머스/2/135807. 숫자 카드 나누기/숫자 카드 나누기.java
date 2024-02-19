class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i=1;i<arrayA.length;i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        
        if(notDiv(arrayA, gcdB)){
            if(answer<gcdB) answer = gcdB;
        }
        
        if(notDiv(arrayB, gcdA)){
            if(answer<gcdA) answer = gcdA;
        }
        
        return answer;
    }
    
    public boolean notDiv(int[] arr, int num){
        for(int number : arr){
            if(number % num == 0)
                return false;
        }
        
        return true;
    }
    
    public int gcd(int A, int B){
        if(A%B == 0) return B;
        return gcd(B, A%B);
    }
}