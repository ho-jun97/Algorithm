package Programmers.두큐합같게만들기;

import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();

        long sum_qu1 = 0, sum_qu2 = 0;
        for(int i=0; i<queue1.length; i++){
            qu1.offer(queue1[i]);
            sum_qu1 += queue1[i];

            qu2.offer(queue2[i]);
            sum_qu2 += queue2[i];
        }
        int answer = 0;
        while(sum_qu1 != sum_qu2){
            if(answer>(queue1.length * 4)){
                return -1;
            }else if(sum_qu1 > sum_qu2){
                int value = qu1.poll();
                sum_qu1 -= value;
                sum_qu2 += value;
                qu2.add(value);
                answer++;
            }else{
                int value = qu2.poll();
                sum_qu2 -= value;
                sum_qu1 += value;
                qu1.add(value);
                answer++;
            }
        }
        return answer;
    }
}
