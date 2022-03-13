package BaekJoon.P11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11000
 * [11000번: 강의실 배정]-Gold5
 */

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];
        for(int i=0;i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(S,T);
        }
        Arrays.sort(lectures, (o1,o2)->Integer.compare(o1.start,o2.start)); // 시작 기준으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐
        pq.add(lectures[0].end); // 처음 시작 강의의 끝나는 시간
        for(int i=1; i<N; i++){
            int end = pq.peek();
            if(end <= lectures[i].start){ // 진행중인 강의의 끝나는 시간이 다음 강의 시작 시간보다 작을 때
                pq.poll();
            }
            pq.add(lectures[i].end); // 다음 강의의 끝나는 시간 추가
        }
        System.out.println(pq.size()); // 우선순위 큐에 size가 강의실를 최소한 사용할 수 있는 개수
    }
    static class Lecture{
        int start;
        int end;
        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
