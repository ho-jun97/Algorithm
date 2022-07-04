package Programmers.디스크컨트롤러;
import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.end, o2.end));
        Arrays.sort(jobs, (o1,o2)->Integer.compare(o1[0],o2[0]));
        int end=0; // 수행이 끝나는 시점
        int count=0; // 실행 횟수
        int index=0; // index 표시
        while(count<jobs.length){

            // 현재 end보다 요청하는 시간이 빠르거나 같으면 pq에 넣는다.
            while(index < jobs.length && jobs[index][0] <= end){
                pq.add(new Node(jobs[index][0], jobs[index][1]));
                index++;
            }

            // pq가 비워있을 경우 (현재 end보다 요청하는 시간이 느린 경우)
            if(pq.isEmpty()){
                end = jobs[index][0]; // 요청 시점으로 end 설정

            }
            // (현재 end보다 요청하는 시간이 더 빠른 경우)
            else{
                Node node = pq.poll();
                end += node.end;
                answer += (end - node.start);
                count++;
            }
        }
        answer /= jobs.length;
        return answer;
    }
    class Node{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}