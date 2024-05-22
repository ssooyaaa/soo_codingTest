class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int[] in = new int[1000001];
        int[] out = new int[1000001]; 
        
        for (int[] edge : edges) {
            out[edge[0]]++; // 정점당 나가는 선 수
            in[edge[1]]++; // 정점당 들어오는 선 수
        }
        
        for (int i = 1; i < 1000001; i++) {
            // 들어오는 선이 없고 나가는 선이 2개 이상(모든 그래프 수의 합은 2이상)이면 시작 정점
            if (in[i] == 0 && out[i] > 1) {
                answer[0] = i;
            }
            // 나가는 선은 없고 들어오는 선이 1개 이상이면 막대 모양 그래프
            else if (out[i] == 0 && in[i] >= 1) {
                answer[2]++;
            }
            // 들어오는 선이 2개 이상이고 나가는 선도 2개 이상이면 8자 모양 그래프
            else if (in[i] >= 2 && out[i] >= 2) {
                answer[3]++;
            }
        }
        // 시작 정점의 나가는 선 수(전체 그래프 수)에서 다른 그래프들 수를 빼면 도넛 모양 그래프 수
        answer[1] = out[answer[0]] - answer[2] - answer[3];
        
        return answer;
    }
}