package Programmers.디펜스게임;

import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++){
            n -= enemy[i];
            pq.add(enemy[i]);
            if(n < 0){
                if(k > 0){
                    n += pq.poll();
                    k--;
                    continue;
                }
                return i;
            }
        }
        return enemy.length;
    }
}
