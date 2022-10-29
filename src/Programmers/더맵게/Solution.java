package Programmers.더맵게;

import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        int cnt = 0;
        while(true){
            if(pq.peek() < K && pq.size() < 2){ // K보다 작고 더 이상 작업을 진행하지 못할 때
                break;
            }
            if(pq.peek() >= K){ // 첫 번째 원소가 K보다 크면 지금까지 발생한 횟수 리턴
                return cnt;
            }
            int a = pq.poll();
            int b = pq.poll();
            int result = a + b * 2;
            pq.add(result);
            cnt++;
        }
        return -1;
    }
}
