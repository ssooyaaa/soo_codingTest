import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        
        for(int i=0;i<A.length;i++){
            listA.add(A[i]);
        }
        for(int i=0;i<B.length;i++){
            listB.add(B[i]);
        }
        
        Collections.sort(listA);
        Collections.sort(listB, Collections.reverseOrder());
        
        for(int i=0;i<A.length;i++){
            answer += listA.get(i)*listB.get(i);
        }

        return answer;
    }
}