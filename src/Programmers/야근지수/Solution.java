import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 우선순위높은순서
        
        // work 들 우선순위 큐에 넣기
        for(int work : works){
            pq.add(work);
        }
        
        // 우선순위큐가 비어있지 않거나 퇴근시간(N==0)일 때까지
        while(!pq.isEmpty() && n-- > 0){
            int work = pq.poll() - 1;
            if(work != 0){
                pq.add(work);
            }
        }
        // 우선순위큐에 남아있는 야근업무량
        while(!pq.isEmpty()){
            int work = pq.poll();
            answer += (work*work);
        }
        

        return answer;
    }
}
