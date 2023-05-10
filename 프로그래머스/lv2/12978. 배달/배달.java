class Solution {
    static final int INF = 500001;
    static int count = 0;
    static int[] dist;
    static boolean[] visited;
    static int[][] map;
    
    public int solution(int N, int[][] road, int K) {
        map = new int[N+1][N+1];
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j] = INF;
            }
        }
        
        for(int i=0;i<road.length;i++){
            if(map[road[i][0]][road[i][1]]>road[i][2]){
                map[road[i][0]][road[i][1]] = road[i][2];
                map[road[i][1]][road[i][0]] = road[i][2];
            }
        }
        
        dist = new int[N+1];
        for(int i=2;i<=N;i++){
            dist[i] = (dist[i]==0)? INF:map[1][i];
        }
        visited = new boolean[N+1];
        visited[1] = true;
        
        dijkstra(N,K);
    
        int answer = count;
        return answer;
    }
    
    public void dijkstra(int N, int K){
        for(int i=1;i<N;i++){
            int min = INF;
            int idx = 1;
            
            for(int j=1;j<=N;j++){
                if(!visited[j] && min>dist[j]){
                    idx = j;
                    min = dist[j];
                }
            }
            
            visited[idx] = true;
            
            for(int j=2;j<=N;j++){
                if(dist[j]>dist[idx]+map[idx][j]){
                    dist[j]=dist[idx]+map[idx][j];
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            if(dist[i]<=K) count++;
        }
    }
}