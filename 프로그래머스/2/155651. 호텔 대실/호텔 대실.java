import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] booking = new int[book_time.length][2];

        //시간을 분으로 변경
        for (int i = 0; i < book_time.length; i++) {
            String[][] temp = new String[2][2];
            temp[0] = book_time[i][0].split(":");
            temp[1] = book_time[i][1].split(":");

            booking[i][0] = Integer.parseInt(temp[0][0]) * 60 + Integer.parseInt(temp[0][1]);
            booking[i][1] = Integer.parseInt(temp[1][0]) * 60 + Integer.parseInt(temp[1][1]) + 10;
        }

        Arrays.sort(booking, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < booking.length; i++) {
            if(!pq.isEmpty()) {
                if (pq.peek() <= booking[i][0]) {
                    pq.poll();
                }
            }
            pq.add(booking[i][1]);
        }

        return pq.size();
    }
}