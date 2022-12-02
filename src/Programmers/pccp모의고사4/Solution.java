package Programmers.pccp모의고사4;

import java.util.*;
class Solution {
    public long[] solution(int[][] program) {
        long[] answer = new long[11];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->{
            return o1[0]==o2[0] ? o1[1]-o2[1] : o1[0] - o2[0];
        });
        Arrays.sort(program, (o1,o2)-> o1[1] - o2[1]);

        int end = 0, index = 0, count = 0;
        while(count < program.length){
            while(index < program.length && program[index][1] <= end){
                pq.add(program[index++]);
            }
            if(pq.isEmpty()){
                end = program[index][1];
                continue;
            }
            int[] p = pq.poll();
            answer[p[0]] += end - p[1];
            end += p[2];
            count++;
        }
        answer[0] = end;

        return answer;
    }
}
